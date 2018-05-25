package com.lizhao.ai.impl.condition;

import com.lizhao.ai.common.EStatus;
import com.lizhao.ai.abs.BaseCondition;
import com.lizhao.ai.ifs.IBehaviour;

public class ConditionIsHealthLow extends BaseCondition {

  @Override
  public EStatus update() {
    int random = getRandom();
    if (random < 30) {
      System.out.println("Health is low");
      return !isNegation() ? EStatus.Success : EStatus.Failure;
    } else {
      System.out.println("Health is Not low");
      return !isNegation() ? EStatus.Failure : EStatus.Success;
    }

  }

  @Override
  public void addChild(IBehaviour child) {
  }
}
