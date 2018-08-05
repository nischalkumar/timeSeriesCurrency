PREFACE
This is a service which can be plugged as REST api or as an library.

Setup:
Its a gradle project. It can be imported as a gradle project in any editor . It can be packaged as a jar 

Choice of Tech:
JAVA: only a few langugages support inherent Multi threading support
TimeSeries DB: The use case of time currency data has particular characteristics:
1.Inserts are immutable
2.After batch random insertions, Inserts will mostly by in sorted order.
3.Reads are random
4.Reads can be of range 

There are many popular timeSeries DB. But I have tried to implement in memory TimeSeries db for simplicity of the solutions.

DataStructure: Sorted Map so that inserts are auto sorted on the basis of time.

Conversion:
Check tests of com.blueoptima.kuber.common.ConverterTest com.blueoptima.kuber.TimeSeriesDaoImplTest
