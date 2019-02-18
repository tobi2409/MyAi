# Artificial Intelligence - Sample Application by Tobias Hollstein 2019

A human has several options to change something in the world. So he can use his muscle power to affect other particles. If you are in the phase where you are still exploring the world, you are gaining experience and because you are pursuing certain goals based on your emotions (e.g. no hunger), some of the experiences are considered pleasant, others unpleasant. Not every action leads to the goal being achieved. When I, as a human being, decide on an action (option), I remember whether and how often this applied option has fulfilled my goal.

The sample world in this application is a vector with truth values, so you can keep it simple for now. There are 3 options (actions) how to influence this world. The first option causes any true value in the vector to get wrong if the value on the next position is wrong. The second option inverts the values. The third option sets all values to true.

![alt text](https://imagizer.imageshack.com/img924/4674/5BOurv.png)

As soon as man acts, he does not see the effects that his action has on the whole universe, but only on a small part. Therefore, when exploring the world (method: inspect in AiLogic), only one index is considered in the array. The result of this method is a list of InspectionEntries. An InspectionEntry contains the value as it was before the action, the value after the action, the position (index) and the option.

The "analyze" method uses the InspectionList to count how often a certain "after value" has arisen for a "before value". The parameters "compareProperty" and "comparePropertyValue" can be used to specify whether only a certain option (action) or only a certain index (position) is to be taken into account for the count.
The "analyzePrecise" method examines several values of a property. (e.g.: several options or several positions).
If the method "analyze" contains only one entry, because there was always only one "after value" in the count, the combination of the "before value" with e.g. the option is considered universal.
The method "traceGoal" is used to search for a fixed "after value" from the InspectionList and with the help of the InspectionEntry you know that for the "before value" and this option or this index (depending on) times the "after value" has been created, which you have set as the target. And then you can analyze how often this "after value" was created and how often another "after value" came out, which may not be desired as a target.

The project is still in the development phase and therefore the FrontEnd, which is supposed to combine all the AiLogic modules, is not really helpful yet. But the tests show that the AiLogic modules work so far.

What may also be missing is an analysis method that combines e.g. options with positions, so that it can then be determined whether, for example, a certain option always produces the same "after value" only in combination with a certain position.

If you want to participate in the project, you can reach me under the following mail.

Mail: tbshollstein@gmail.com

Wiki: https://github.com/tobi2409/MyAi/wiki
