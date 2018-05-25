package com.lizhao;

import com.lizhao.ai.BehaviorTree;
import com.lizhao.ai.BehaviorTreeBuilder;
import com.lizhao.ai.common.EPolicy;
import com.lizhao.ai.impl.action.ActionAttack;
import com.lizhao.ai.impl.action.ActionPatrol;
import com.lizhao.ai.impl.action.ActionRunaway;
import com.lizhao.ai.impl.composite.ParallelImpl;
import com.lizhao.ai.impl.composite.SelectorImpl;
import com.lizhao.ai.impl.composite.SequenceImpl;
import com.lizhao.ai.impl.condition.ConditionIsEnemyDead;
import com.lizhao.ai.impl.condition.ConditionIsHealthLow;
import com.lizhao.ai.impl.condition.ConditionIsSeeEnemy;
import com.lizhao.ai.impl.decorator.Repeat;

public class Main {
  public static void main(String[] args) {
    BehaviorTreeBuilder builder = new BehaviorTreeBuilder();
    BehaviorTree behaviorTree =
          builder.addBehaviour(new SelectorImpl())
            .addBehaviour(new SequenceImpl())
              .addBehaviour(new ConditionIsSeeEnemy())
                .back()
              .addBehaviour(new SelectorImpl())
                .addBehaviour(new SequenceImpl())
                  .addBehaviour(new ConditionIsHealthLow())
                    .back()
                  .addBehaviour(new ActionRunaway())
                    .back()
                  .back()

                .addBehaviour(new ParallelImpl(EPolicy.RequireAll,EPolicy.RequireOne))
                  .addBehaviour(new ConditionIsEnemyDead(true))
                         .back()
                  .addBehaviour(new Repeat())
                    .addBehaviour(new ActionAttack())
                      .back()
                    .back()
                  .back()
                .back()
              .back()
            .addBehaviour(new ActionPatrol())
        .end();

    //模拟执行行为树
    for (int i = 0; i < 10; ++i){
      behaviorTree.tick();
      System.out.println("--------------" + i + "------------");
    }

    System.out.println("pause ");
  }
}
