package com.lizhao.ai;

import com.lizhao.ai.itf.IBehavior;

public class BehaviorTree {
  private IBehavior root;

  public BehaviorTree(IBehavior root) {
    this.root = root;
  }

  public void tick() {
    root.tick();
  }

  public boolean haveRoot() {
    return root != null ? true : false;
  }

  public void setRoot(IBehavior inNode) {
    root = inNode;
  }

  public void release() {
    root.release();
  }

}