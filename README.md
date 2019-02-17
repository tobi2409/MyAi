# Artifical Intelligence - Sample Application by Tobias Hollstein 2019

This Application demonstrates a sample functionality of an Artifical Intelligence.
The fundamental idea to realize an artifical Intelligence, you must be clear what is Intelligence.
There are different opinions about the word 'Intelligence'. So we have to rethink about this topic.

We have to think about what we would do if we could live in the universe and we don't need food or oxygen to survive.
We live/survive no matter what happens. We also haven't got all inventions/languages which are available nowadays.
And imagine we don't have procreation and we aren't interested in exploring the universe.
The difference is that we wouldn't have any emotions because when we don't need anything,
we wouldn't have any goals and that leads that we won't need to fight for something.

By this my Artifical Intelligence implements a sample World called 'Vector'.
This sample vector isn't complexe because this sample should only demonstrate on an easy way how Intelligence works.
In my test cases you can find some generated vectors.
With the VectorLogic you can influence the Vector by passing an Option.
An option is that what you are able to do to influence the elements of the world.
The options are similar to our muscles or the force of our particles.
We can influence elements of the world with forces or with our muscles.

With the AiLogic we are able to inspect the vector and compare which change of the world is most common.
You can imagine this with following simple example.
There are 4 pots. You want to know what would be happen with the pots when you do something.
You have many options provided by your physical strength (muscles) you are able to do with the pots.
One option is to knock the pot. So you can inspect easily all of the pots what are happening by knocking.
So imagine 3 of the 4 pots sound by doing this option.
The AnalyzeMap compares how often the pot sounds.
So if you are looking for a goal that the pot should sound you are able to trace the goal from the InspectionList.
You can analyze it by passing the oldValue of the traced goal and the option (or all options by analyzePrecise).
Then you know that in 3 of 4 cases it sounds by knocking on the pot and this is a safe option that it would sound.
You are working with only one index because in the real world you also don't realize the effects of all the universe.
Only a little part.

An easy Run-Method (my example must be improved) provides an Frontend to combine all of the modules.
Starting with having goals and ending with solving by the evaluation of the AnalyzeMap.
You also could imagine that not all options are available to try like it is in the real world.
Because e.g. you haven't got the necessary physical strength to inspect something or missing materials.

TODO: Inspect/Analyze instead of a single Index a part of the Vector.
