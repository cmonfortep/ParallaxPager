package com.prolificinteractive.parallaxpager;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

public class ParallaxContextWrapper extends ContextWrapper {

  private LayoutInflater inflater;

  private final ParallaxFactory mFactory;

  public ParallaxContextWrapper(Context base, OnViewCreatedListener... onViewCreatedListener) {
    super(base);
    mFactory = new ParallaxFactory(onViewCreatedListener);
  }

  @Override
  public Object getSystemService(String name) {
    if (LAYOUT_INFLATER_SERVICE.equals(name)) {
      if (inflater == null) {
        inflater = new ParallaxLayoutInflater(
            LayoutInflater.from(getBaseContext()),
            this,
            mFactory, true);
      }
      return inflater;
    }
    return super.getSystemService(name);
  }
}
