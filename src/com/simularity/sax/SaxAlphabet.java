// SaxAlphabet - Abstraction of the SAX Alphabet concept
// Supports SaxAlphabets from 2 .. 16 letters

package com.simularity.sax;
import java.io.*;
import java.util.ArrayList;
import java.math.BigInteger;

public class SaxAlphabet {
	public enum Alphabet {SAX_2, SAX_3, SAX_4, SAX_5, SAX_6, SAX_7, SAX_8, SAX_9,
				SAX_10, SAX_11, SAX_12, SAX_13, SAX_14, SAX_15, SAX_16, SAX_17, SAX_18, SAX_19, SAX_20, SAX_21, SAX_22, SAX_23,
				 SAX_24, SAX_25, SAX_26, SAX_27, SAX_28, SAX_29, SAX_30, SAX_31, SAX_32, SAX_33, SAX_34, SAX_35, SAX_36, 
				 SAX_37, SAX_38, SAX_39, SAX_40, SAX_41, SAX_42, SAX_43, SAX_44, SAX_45, SAX_46, SAX_47, SAX_48, SAX_49, 
				 SAX_50, SAX_51, SAX_52, SAX_53, SAX_54, SAX_55, SAX_56, SAX_57, SAX_58, SAX_59, SAX_60, SAX_61, SAX_62, 
				 SAX_63, SAX_64, SAX_65, SAX_66, SAX_67, SAX_68, SAX_69, SAX_70, SAX_71, SAX_72, SAX_73, SAX_74, SAX_75, 
				 SAX_76, SAX_77, SAX_78, SAX_79, SAX_80, SAX_81, SAX_82, SAX_83, SAX_84, SAX_85, SAX_86, SAX_87, SAX_88, 
				 SAX_89, SAX_90, SAX_91, SAX_92, SAX_93, SAX_94, SAX_95, SAX_96, SAX_97, SAX_98, SAX_99, SAX_100, SAX_101, 
				 SAX_102, SAX_103, SAX_104, SAX_105, SAX_106, SAX_107, SAX_108, SAX_109, SAX_110, SAX_111, SAX_112, SAX_113, 
				 SAX_114, SAX_115, SAX_116, SAX_117, SAX_118, SAX_119, SAX_120, SAX_121, SAX_122, SAX_123, SAX_124, SAX_125, 
				 SAX_126, SAX_127, SAX_128, SAX_129, SAX_130, SAX_131, SAX_132, SAX_133, SAX_134, SAX_135, SAX_136, SAX_137, 
				 SAX_138, SAX_139, SAX_140, SAX_141, SAX_142, SAX_143, SAX_144, SAX_145, SAX_146, SAX_147, SAX_148, SAX_149, 
				 SAX_150, SAX_151, SAX_152, SAX_153, SAX_154, SAX_155, SAX_156, SAX_157, SAX_158, SAX_159, SAX_160, SAX_161, 
				 SAX_162, SAX_163, SAX_164, SAX_165, SAX_166, SAX_167, SAX_168, SAX_169, SAX_170, SAX_171, SAX_172, SAX_173, 
				 SAX_174, SAX_175, SAX_176, SAX_177, SAX_178, SAX_179, SAX_180, SAX_181, SAX_182, SAX_183, SAX_184, SAX_185, 
				 SAX_186, SAX_187, SAX_188, SAX_189, SAX_190, SAX_191, SAX_192, SAX_193, SAX_194, SAX_195, SAX_196, SAX_197, 
				 SAX_198, SAX_199, SAX_200, SAX_201, SAX_202, SAX_203, SAX_204, SAX_205, SAX_206, SAX_207, SAX_208, SAX_209, 
				 SAX_210, SAX_211, SAX_212, SAX_213, SAX_214, SAX_215, SAX_216, SAX_217, SAX_218, SAX_219, SAX_220, SAX_221, 
				 SAX_222, SAX_223, SAX_224, SAX_225, SAX_226, SAX_227, SAX_228, SAX_229, SAX_230, SAX_231, SAX_232, SAX_233, 
				 SAX_234, SAX_235, SAX_236, SAX_237, SAX_238, SAX_239, SAX_240, SAX_241, SAX_242, SAX_243, SAX_244, SAX_245, 
				 SAX_246, SAX_247, SAX_248, SAX_249, SAX_250, SAX_251, SAX_252, SAX_253, SAX_254, SAX_255, SAX_256, SAX_257, 
				 SAX_258, SAX_259, SAX_260, SAX_261, SAX_262, SAX_263, SAX_264, SAX_265, SAX_266, SAX_267, SAX_268, SAX_269, 
				 SAX_270, SAX_271, SAX_272, SAX_273, SAX_274, SAX_275, SAX_276, SAX_277, SAX_278, SAX_279, SAX_280, SAX_281, 
				 SAX_282, SAX_283, SAX_284, SAX_285, SAX_286, SAX_287, SAX_288, SAX_289, SAX_290, SAX_291, SAX_292, SAX_293, 
				 SAX_294, SAX_295, SAX_296, SAX_297, SAX_298, SAX_299, SAX_300, SAX_301, SAX_302, SAX_303, SAX_304, SAX_305, 
				 SAX_306, SAX_307, SAX_308, SAX_309, SAX_310, SAX_311, SAX_312, SAX_313, SAX_314, SAX_315, SAX_316, SAX_317, 
				 SAX_318, SAX_319, SAX_320, SAX_321, SAX_322, SAX_323, SAX_324, SAX_325, SAX_326, SAX_327, SAX_328, SAX_329, 
				 SAX_330, SAX_331, SAX_332, SAX_333, SAX_334, SAX_335, SAX_336, SAX_337, SAX_338, SAX_339, SAX_340, SAX_341, 
				 SAX_342, SAX_343, SAX_344, SAX_345, SAX_346, SAX_347, SAX_348, SAX_349, SAX_350, SAX_351, SAX_352, SAX_353, 
				 SAX_354, SAX_355, SAX_356, SAX_357, SAX_358, SAX_359, SAX_360, SAX_361, SAX_362, SAX_363, SAX_364, SAX_365, 
				 SAX_366, SAX_367, SAX_368, SAX_369, SAX_370, SAX_371, SAX_372, SAX_373, SAX_374, SAX_375, SAX_376, SAX_377, 
				 SAX_378, SAX_379, SAX_380, SAX_381, SAX_382, SAX_383, SAX_384, SAX_385, SAX_386, SAX_387, SAX_388, SAX_389, 
				 SAX_390, SAX_391, SAX_392, SAX_393, SAX_394, SAX_395, SAX_396, SAX_397, SAX_398, SAX_399, SAX_400, SAX_401, 
				 SAX_402, SAX_403, SAX_404, SAX_405, SAX_406, SAX_407, SAX_408, SAX_409, SAX_410, SAX_411, SAX_412, SAX_413, 
				 SAX_414, SAX_415, SAX_416, SAX_417, SAX_418, SAX_419, SAX_420, SAX_421, SAX_422, SAX_423, SAX_424, SAX_425, 
				 SAX_426, SAX_427, SAX_428, SAX_429, SAX_430, SAX_431, SAX_432, SAX_433, SAX_434, SAX_435, SAX_436, SAX_437, 
				 SAX_438, SAX_439, SAX_440, SAX_441, SAX_442, SAX_443, SAX_444, SAX_445, SAX_446, SAX_447, SAX_448, SAX_449, 
				 SAX_450, SAX_451, SAX_452, SAX_453, SAX_454, SAX_455, SAX_456, SAX_457, SAX_458, SAX_459, SAX_460, SAX_461, 
				 SAX_462, SAX_463, SAX_464, SAX_465, SAX_466, SAX_467, SAX_468, SAX_469, SAX_470, SAX_471, SAX_472, SAX_473, 
				 SAX_474, SAX_475, SAX_476, SAX_477, SAX_478, SAX_479, SAX_480, SAX_481, SAX_482, SAX_483, SAX_484, SAX_485, 
				 SAX_486, SAX_487, SAX_488, SAX_489, SAX_490, SAX_491, SAX_492, SAX_493, SAX_494, SAX_495, SAX_496, SAX_497, 
				 SAX_498, SAX_499, SAX_500, SAX_501, SAX_502, SAX_503, SAX_504, SAX_505, SAX_506, SAX_507, SAX_508, SAX_509, 
				 SAX_510, SAX_511, SAX_512, SAX_513, SAX_514, SAX_515, SAX_516, SAX_517, SAX_518, SAX_519, SAX_520, SAX_521, 
				 SAX_522, SAX_523, SAX_524, SAX_525, SAX_526, SAX_527, SAX_528, SAX_529, SAX_530, SAX_531, SAX_532, SAX_533, 
				 SAX_534, SAX_535, SAX_536, SAX_537, SAX_538, SAX_539, SAX_540, SAX_541, SAX_542, SAX_543, SAX_544, SAX_545, 
				 SAX_546, SAX_547, SAX_548, SAX_549, SAX_550, SAX_551, SAX_552, SAX_553, SAX_554, SAX_555, SAX_556, SAX_557, 
				 SAX_558, SAX_559, SAX_560, SAX_561, SAX_562, SAX_563, SAX_564, SAX_565, SAX_566, SAX_567, SAX_568, SAX_569, 
				 SAX_570, SAX_571, SAX_572, SAX_573, SAX_574, SAX_575, SAX_576, SAX_577, SAX_578, SAX_579, SAX_580, SAX_581, 
				 SAX_582, SAX_583, SAX_584, SAX_585, SAX_586, SAX_587, SAX_588, SAX_589, SAX_590, SAX_591, SAX_592, SAX_593, 
				 SAX_594, SAX_595, SAX_596, SAX_597, SAX_598, SAX_599, SAX_600, SAX_601, SAX_602, SAX_603, SAX_604, SAX_605, 
				 SAX_606, SAX_607, SAX_608, SAX_609, SAX_610, SAX_611, SAX_612, SAX_613, SAX_614, SAX_615, SAX_616, SAX_617, 
				 SAX_618, SAX_619, SAX_620, SAX_621, SAX_622, SAX_623, SAX_624, SAX_625, SAX_626, SAX_627, SAX_628, SAX_629, 
				 SAX_630, SAX_631, SAX_632, SAX_633, SAX_634, SAX_635, SAX_636, SAX_637, SAX_638, SAX_639, SAX_640, SAX_641, 
				 SAX_642, SAX_643, SAX_644, SAX_645, SAX_646, SAX_647, SAX_648, SAX_649, SAX_650, SAX_651, SAX_652, SAX_653, 
				 SAX_654, SAX_655, SAX_656, SAX_657, SAX_658, SAX_659, SAX_660, SAX_661, SAX_662, SAX_663, SAX_664, SAX_665, 
				 SAX_666, SAX_667, SAX_668, SAX_669, SAX_670, SAX_671, SAX_672, SAX_673, SAX_674, SAX_675, SAX_676, SAX_677, 
				 SAX_678, SAX_679, SAX_680, SAX_681, SAX_682, SAX_683, SAX_684, SAX_685, SAX_686, SAX_687, SAX_688, SAX_689, 
				 SAX_690, SAX_691, SAX_692, SAX_693, SAX_694, SAX_695, SAX_696, SAX_697, SAX_698, SAX_699, SAX_700, SAX_701, 
				 SAX_702, SAX_703, SAX_704, SAX_705, SAX_706, SAX_707, SAX_708, SAX_709, SAX_710, SAX_711, SAX_712, SAX_713, 
				 SAX_714, SAX_715, SAX_716, SAX_717, SAX_718, SAX_719, SAX_720, SAX_721, SAX_722, SAX_723, SAX_724, SAX_725, 
				 SAX_726, SAX_727, SAX_728, SAX_729, SAX_730, SAX_731, SAX_732, SAX_733, SAX_734, SAX_735, SAX_736, SAX_737, 
				 SAX_738, SAX_739, SAX_740, SAX_741, SAX_742, SAX_743, SAX_744, SAX_745, SAX_746, SAX_747, SAX_748, SAX_749, 
				 SAX_750, SAX_751, SAX_752, SAX_753, SAX_754, SAX_755, SAX_756, SAX_757, SAX_758, SAX_759, SAX_760, SAX_761, 
				 SAX_762, SAX_763, SAX_764, SAX_765, SAX_766, SAX_767, SAX_768, SAX_769, SAX_770, SAX_771, SAX_772, SAX_773, 
				 SAX_774, SAX_775, SAX_776, SAX_777, SAX_778, SAX_779, SAX_780, SAX_781, SAX_782, SAX_783, SAX_784, SAX_785, 
				 SAX_786, SAX_787, SAX_788, SAX_789, SAX_790, SAX_791, SAX_792, SAX_793, SAX_794, SAX_795, SAX_796, SAX_797, 
				 SAX_798, SAX_799, SAX_800, SAX_801, SAX_802, SAX_803, SAX_804, SAX_805, SAX_806, SAX_807, SAX_808, SAX_809, 
				 SAX_810, SAX_811, SAX_812, SAX_813, SAX_814, SAX_815, SAX_816, SAX_817, SAX_818, SAX_819, SAX_820, SAX_821, 
				 SAX_822, SAX_823, SAX_824, SAX_825, SAX_826, SAX_827, SAX_828, SAX_829, SAX_830, SAX_831, SAX_832, SAX_833, 
				 SAX_834, SAX_835, SAX_836, SAX_837, SAX_838, SAX_839, SAX_840, SAX_841, SAX_842, SAX_843, SAX_844, SAX_845, 
				 SAX_846, SAX_847, SAX_848, SAX_849, SAX_850, SAX_851, SAX_852, SAX_853, SAX_854, SAX_855, SAX_856, SAX_857, 
				 SAX_858, SAX_859, SAX_860, SAX_861, SAX_862, SAX_863, SAX_864, SAX_865, SAX_866, SAX_867, SAX_868, SAX_869, 
				 SAX_870, SAX_871, SAX_872, SAX_873, SAX_874, SAX_875, SAX_876, SAX_877, SAX_878, SAX_879, SAX_880, SAX_881, 
				 SAX_882, SAX_883, SAX_884, SAX_885, SAX_886, SAX_887, SAX_888, SAX_889, SAX_890, SAX_891, SAX_892, SAX_893, 
				 SAX_894, SAX_895, SAX_896, SAX_897, SAX_898, SAX_899, SAX_900, SAX_901, SAX_902, SAX_903, SAX_904, SAX_905, 
				 SAX_906, SAX_907, SAX_908, SAX_909, SAX_910, SAX_911, SAX_912, SAX_913, SAX_914, SAX_915, SAX_916, SAX_917, 
				 SAX_918, SAX_919, SAX_920, SAX_921, SAX_922, SAX_923, SAX_924, SAX_925, SAX_926, SAX_927, SAX_928, SAX_929, 
				 SAX_930, SAX_931, SAX_932, SAX_933, SAX_934, SAX_935, SAX_936, SAX_937, SAX_938, SAX_939, SAX_940, SAX_941, 
				 SAX_942, SAX_943, SAX_944, SAX_945, SAX_946, SAX_947, SAX_948, SAX_949, SAX_950, SAX_951, SAX_952, SAX_953, 
				 SAX_954, SAX_955, SAX_956, SAX_957, SAX_958, SAX_959, SAX_960, SAX_961, SAX_962, SAX_963, SAX_964, SAX_965, 
				 SAX_966, SAX_967, SAX_968, SAX_969, SAX_970, SAX_971, SAX_972, SAX_973, SAX_974, SAX_975, SAX_976, SAX_977, 
				 SAX_978, SAX_979, SAX_980, SAX_981, SAX_982, SAX_983, SAX_984, SAX_985, SAX_986, SAX_987, SAX_988, SAX_989, 
				 SAX_990, SAX_991, SAX_992, SAX_993, SAX_994, SAX_995, SAX_996, SAX_997, SAX_998, SAX_999, SAX_1000, SAX_1001, 
				 SAX_1002, SAX_1003, SAX_1004, SAX_1005, SAX_1006, SAX_1007, SAX_1008, SAX_1009, SAX_1010, SAX_1011, SAX_1012, 
				 SAX_1013, SAX_1014, SAX_1015, SAX_1016, SAX_1017, SAX_1018, SAX_1019, SAX_1020, SAX_1021, SAX_1022, SAX_1023, 
				 SAX_1024};


	protected static Alphabet [] alphabet = {Alphabet.SAX_2, Alphabet.SAX_3, Alphabet.SAX_4, Alphabet.SAX_5, Alphabet.SAX_6, Alphabet.SAX_7, Alphabet.SAX_8, Alphabet.SAX_9,
				 Alphabet.SAX_10, Alphabet.SAX_11, Alphabet.SAX_12, Alphabet.SAX_13, Alphabet.SAX_14, Alphabet.SAX_15,
						 Alphabet.SAX_16, Alphabet.SAX_17, Alphabet.SAX_18, Alphabet.SAX_19, Alphabet.SAX_20,
						 Alphabet.SAX_21, Alphabet.SAX_22, Alphabet.SAX_23,
				 Alphabet.SAX_24, Alphabet.SAX_25, Alphabet.SAX_26, Alphabet.SAX_27, Alphabet.SAX_28, Alphabet.SAX_29, Alphabet.SAX_30, Alphabet.SAX_31, Alphabet.SAX_32, Alphabet.SAX_33, Alphabet.SAX_34, Alphabet.SAX_35, Alphabet.SAX_36, 
				 Alphabet.SAX_37, Alphabet.SAX_38, Alphabet.SAX_39, Alphabet.SAX_40, Alphabet.SAX_41, Alphabet.SAX_42, Alphabet.SAX_43, Alphabet.SAX_44, Alphabet.SAX_45, Alphabet.SAX_46, Alphabet.SAX_47, Alphabet.SAX_48, Alphabet.SAX_49, 
				 Alphabet.SAX_50, Alphabet.SAX_51, Alphabet.SAX_52, Alphabet.SAX_53, Alphabet.SAX_54, Alphabet.SAX_55, Alphabet.SAX_56, Alphabet.SAX_57, Alphabet.SAX_58, Alphabet.SAX_59, Alphabet.SAX_60, Alphabet.SAX_61, Alphabet.SAX_62, 
				 Alphabet.SAX_63, Alphabet.SAX_64, Alphabet.SAX_65, Alphabet.SAX_66, Alphabet.SAX_67, Alphabet.SAX_68, Alphabet.SAX_69, Alphabet.SAX_70, Alphabet.SAX_71, Alphabet.SAX_72, Alphabet.SAX_73, Alphabet.SAX_74, Alphabet.SAX_75, 
				 Alphabet.SAX_76, Alphabet.SAX_77, Alphabet.SAX_78, Alphabet.SAX_79, Alphabet.SAX_80, Alphabet.SAX_81, Alphabet.SAX_82, Alphabet.SAX_83, Alphabet.SAX_84, Alphabet.SAX_85, Alphabet.SAX_86, Alphabet.SAX_87, Alphabet.SAX_88, 
				 Alphabet.SAX_89, Alphabet.SAX_90, Alphabet.SAX_91, Alphabet.SAX_92, Alphabet.SAX_93, Alphabet.SAX_94, Alphabet.SAX_95, Alphabet.SAX_96, Alphabet.SAX_97, Alphabet.SAX_98, Alphabet.SAX_99, Alphabet.SAX_100, Alphabet.SAX_101, 
				 Alphabet.SAX_102, Alphabet.SAX_103, Alphabet.SAX_104, Alphabet.SAX_105, Alphabet.SAX_106, Alphabet.SAX_107, Alphabet.SAX_108, Alphabet.SAX_109, Alphabet.SAX_110, Alphabet.SAX_111, Alphabet.SAX_112, Alphabet.SAX_113, 
				 Alphabet.SAX_114, Alphabet.SAX_115, Alphabet.SAX_116, Alphabet.SAX_117, Alphabet.SAX_118, Alphabet.SAX_119, Alphabet.SAX_120, Alphabet.SAX_121, Alphabet.SAX_122, Alphabet.SAX_123, Alphabet.SAX_124, Alphabet.SAX_125, 
				 Alphabet.SAX_126, Alphabet.SAX_127, Alphabet.SAX_128, Alphabet.SAX_129, Alphabet.SAX_130, Alphabet.SAX_131, Alphabet.SAX_132, Alphabet.SAX_133, Alphabet.SAX_134, Alphabet.SAX_135, Alphabet.SAX_136, Alphabet.SAX_137, 
				 Alphabet.SAX_138, Alphabet.SAX_139, Alphabet.SAX_140, Alphabet.SAX_141, Alphabet.SAX_142, Alphabet.SAX_143, Alphabet.SAX_144, Alphabet.SAX_145, Alphabet.SAX_146, Alphabet.SAX_147, Alphabet.SAX_148, Alphabet.SAX_149, 
				 Alphabet.SAX_150, Alphabet.SAX_151, Alphabet.SAX_152, Alphabet.SAX_153, Alphabet.SAX_154, Alphabet.SAX_155, Alphabet.SAX_156, Alphabet.SAX_157, Alphabet.SAX_158, Alphabet.SAX_159, Alphabet.SAX_160, Alphabet.SAX_161, 
				 Alphabet.SAX_162, Alphabet.SAX_163, Alphabet.SAX_164, Alphabet.SAX_165, Alphabet.SAX_166, Alphabet.SAX_167, Alphabet.SAX_168, Alphabet.SAX_169, Alphabet.SAX_170, Alphabet.SAX_171, Alphabet.SAX_172, Alphabet.SAX_173, 
				 Alphabet.SAX_174, Alphabet.SAX_175, Alphabet.SAX_176, Alphabet.SAX_177, Alphabet.SAX_178, Alphabet.SAX_179, Alphabet.SAX_180, Alphabet.SAX_181, Alphabet.SAX_182, Alphabet.SAX_183, Alphabet.SAX_184, Alphabet.SAX_185, 
				 Alphabet.SAX_186, Alphabet.SAX_187, Alphabet.SAX_188, Alphabet.SAX_189, Alphabet.SAX_190, Alphabet.SAX_191, Alphabet.SAX_192, Alphabet.SAX_193, Alphabet.SAX_194, Alphabet.SAX_195, Alphabet.SAX_196, Alphabet.SAX_197, 
				 Alphabet.SAX_198, Alphabet.SAX_199, Alphabet.SAX_200, Alphabet.SAX_201, Alphabet.SAX_202, Alphabet.SAX_203, Alphabet.SAX_204, Alphabet.SAX_205, Alphabet.SAX_206, Alphabet.SAX_207, Alphabet.SAX_208, Alphabet.SAX_209, 
				 Alphabet.SAX_210, Alphabet.SAX_211, Alphabet.SAX_212, Alphabet.SAX_213, Alphabet.SAX_214, Alphabet.SAX_215, Alphabet.SAX_216, Alphabet.SAX_217, Alphabet.SAX_218, Alphabet.SAX_219, Alphabet.SAX_220, Alphabet.SAX_221, 
				 Alphabet.SAX_222, Alphabet.SAX_223, Alphabet.SAX_224, Alphabet.SAX_225, Alphabet.SAX_226, Alphabet.SAX_227, Alphabet.SAX_228, Alphabet.SAX_229, Alphabet.SAX_230, Alphabet.SAX_231, Alphabet.SAX_232, Alphabet.SAX_233, 
				 Alphabet.SAX_234, Alphabet.SAX_235, Alphabet.SAX_236, Alphabet.SAX_237, Alphabet.SAX_238, Alphabet.SAX_239, Alphabet.SAX_240, Alphabet.SAX_241, Alphabet.SAX_242, Alphabet.SAX_243, Alphabet.SAX_244, Alphabet.SAX_245, 
				 Alphabet.SAX_246, Alphabet.SAX_247, Alphabet.SAX_248, Alphabet.SAX_249, Alphabet.SAX_250, Alphabet.SAX_251, Alphabet.SAX_252, Alphabet.SAX_253, Alphabet.SAX_254, Alphabet.SAX_255, Alphabet.SAX_256, Alphabet.SAX_257, 
				 Alphabet.SAX_258, Alphabet.SAX_259, Alphabet.SAX_260, Alphabet.SAX_261, Alphabet.SAX_262, Alphabet.SAX_263, Alphabet.SAX_264, Alphabet.SAX_265, Alphabet.SAX_266, Alphabet.SAX_267, Alphabet.SAX_268, Alphabet.SAX_269, 
				 Alphabet.SAX_270, Alphabet.SAX_271, Alphabet.SAX_272, Alphabet.SAX_273, Alphabet.SAX_274, Alphabet.SAX_275, Alphabet.SAX_276, Alphabet.SAX_277, Alphabet.SAX_278, Alphabet.SAX_279, Alphabet.SAX_280, Alphabet.SAX_281, 
				 Alphabet.SAX_282, Alphabet.SAX_283, Alphabet.SAX_284, Alphabet.SAX_285, Alphabet.SAX_286, Alphabet.SAX_287, Alphabet.SAX_288, Alphabet.SAX_289, Alphabet.SAX_290, Alphabet.SAX_291, Alphabet.SAX_292, Alphabet.SAX_293, 
				 Alphabet.SAX_294, Alphabet.SAX_295, Alphabet.SAX_296, Alphabet.SAX_297, Alphabet.SAX_298, Alphabet.SAX_299, Alphabet.SAX_300, Alphabet.SAX_301, Alphabet.SAX_302, Alphabet.SAX_303, Alphabet.SAX_304, Alphabet.SAX_305, 
				 Alphabet.SAX_306, Alphabet.SAX_307, Alphabet.SAX_308, Alphabet.SAX_309, Alphabet.SAX_310, Alphabet.SAX_311, Alphabet.SAX_312, Alphabet.SAX_313, Alphabet.SAX_314, Alphabet.SAX_315, Alphabet.SAX_316, Alphabet.SAX_317, 
				 Alphabet.SAX_318, Alphabet.SAX_319, Alphabet.SAX_320, Alphabet.SAX_321, Alphabet.SAX_322, Alphabet.SAX_323, Alphabet.SAX_324, Alphabet.SAX_325, Alphabet.SAX_326, Alphabet.SAX_327, Alphabet.SAX_328, Alphabet.SAX_329, 
				 Alphabet.SAX_330, Alphabet.SAX_331, Alphabet.SAX_332, Alphabet.SAX_333, Alphabet.SAX_334, Alphabet.SAX_335, Alphabet.SAX_336, Alphabet.SAX_337, Alphabet.SAX_338, Alphabet.SAX_339, Alphabet.SAX_340, Alphabet.SAX_341, 
				 Alphabet.SAX_342, Alphabet.SAX_343, Alphabet.SAX_344, Alphabet.SAX_345, Alphabet.SAX_346, Alphabet.SAX_347, Alphabet.SAX_348, Alphabet.SAX_349, Alphabet.SAX_350, Alphabet.SAX_351, Alphabet.SAX_352, Alphabet.SAX_353, 
				 Alphabet.SAX_354, Alphabet.SAX_355, Alphabet.SAX_356, Alphabet.SAX_357, Alphabet.SAX_358, Alphabet.SAX_359, Alphabet.SAX_360, Alphabet.SAX_361, Alphabet.SAX_362, Alphabet.SAX_363, Alphabet.SAX_364, Alphabet.SAX_365, 
				 Alphabet.SAX_366, Alphabet.SAX_367, Alphabet.SAX_368, Alphabet.SAX_369, Alphabet.SAX_370, Alphabet.SAX_371, Alphabet.SAX_372, Alphabet.SAX_373, Alphabet.SAX_374, Alphabet.SAX_375, Alphabet.SAX_376, Alphabet.SAX_377, 
				 Alphabet.SAX_378, Alphabet.SAX_379, Alphabet.SAX_380, Alphabet.SAX_381, Alphabet.SAX_382, Alphabet.SAX_383, Alphabet.SAX_384, Alphabet.SAX_385, Alphabet.SAX_386, Alphabet.SAX_387, Alphabet.SAX_388, Alphabet.SAX_389, 
				 Alphabet.SAX_390, Alphabet.SAX_391, Alphabet.SAX_392, Alphabet.SAX_393, Alphabet.SAX_394, Alphabet.SAX_395, Alphabet.SAX_396, Alphabet.SAX_397, Alphabet.SAX_398, Alphabet.SAX_399, Alphabet.SAX_400, Alphabet.SAX_401, 
				 Alphabet.SAX_402, Alphabet.SAX_403, Alphabet.SAX_404, Alphabet.SAX_405, Alphabet.SAX_406, Alphabet.SAX_407, Alphabet.SAX_408, Alphabet.SAX_409, Alphabet.SAX_410, Alphabet.SAX_411, Alphabet.SAX_412, Alphabet.SAX_413, 
				 Alphabet.SAX_414, Alphabet.SAX_415, Alphabet.SAX_416, Alphabet.SAX_417, Alphabet.SAX_418, Alphabet.SAX_419, Alphabet.SAX_420, Alphabet.SAX_421, Alphabet.SAX_422, Alphabet.SAX_423, Alphabet.SAX_424, Alphabet.SAX_425, 
				 Alphabet.SAX_426, Alphabet.SAX_427, Alphabet.SAX_428, Alphabet.SAX_429, Alphabet.SAX_430, Alphabet.SAX_431, Alphabet.SAX_432, Alphabet.SAX_433, Alphabet.SAX_434, Alphabet.SAX_435, Alphabet.SAX_436, Alphabet.SAX_437, 
				 Alphabet.SAX_438, Alphabet.SAX_439, Alphabet.SAX_440, Alphabet.SAX_441, Alphabet.SAX_442, Alphabet.SAX_443, Alphabet.SAX_444, Alphabet.SAX_445, Alphabet.SAX_446, Alphabet.SAX_447, Alphabet.SAX_448, Alphabet.SAX_449, 
				 Alphabet.SAX_450, Alphabet.SAX_451, Alphabet.SAX_452, Alphabet.SAX_453, Alphabet.SAX_454, Alphabet.SAX_455, Alphabet.SAX_456, Alphabet.SAX_457, Alphabet.SAX_458, Alphabet.SAX_459, Alphabet.SAX_460, Alphabet.SAX_461, 
				 Alphabet.SAX_462, Alphabet.SAX_463, Alphabet.SAX_464, Alphabet.SAX_465, Alphabet.SAX_466, Alphabet.SAX_467, Alphabet.SAX_468, Alphabet.SAX_469, Alphabet.SAX_470, Alphabet.SAX_471, Alphabet.SAX_472, Alphabet.SAX_473, 
				 Alphabet.SAX_474, Alphabet.SAX_475, Alphabet.SAX_476, Alphabet.SAX_477, Alphabet.SAX_478, Alphabet.SAX_479, Alphabet.SAX_480, Alphabet.SAX_481, Alphabet.SAX_482, Alphabet.SAX_483, Alphabet.SAX_484, Alphabet.SAX_485, 
				 Alphabet.SAX_486, Alphabet.SAX_487, Alphabet.SAX_488, Alphabet.SAX_489, Alphabet.SAX_490, Alphabet.SAX_491, Alphabet.SAX_492, Alphabet.SAX_493, Alphabet.SAX_494, Alphabet.SAX_495, Alphabet.SAX_496, Alphabet.SAX_497, 
				 Alphabet.SAX_498, Alphabet.SAX_499, Alphabet.SAX_500, Alphabet.SAX_501, Alphabet.SAX_502, Alphabet.SAX_503, Alphabet.SAX_504, Alphabet.SAX_505, Alphabet.SAX_506, Alphabet.SAX_507, Alphabet.SAX_508, Alphabet.SAX_509, 
				 Alphabet.SAX_510, Alphabet.SAX_511, Alphabet.SAX_512, Alphabet.SAX_513, Alphabet.SAX_514, Alphabet.SAX_515, Alphabet.SAX_516, Alphabet.SAX_517, Alphabet.SAX_518, Alphabet.SAX_519, Alphabet.SAX_520, Alphabet.SAX_521, 
				 Alphabet.SAX_522, Alphabet.SAX_523, Alphabet.SAX_524, Alphabet.SAX_525, Alphabet.SAX_526, Alphabet.SAX_527, Alphabet.SAX_528, Alphabet.SAX_529, Alphabet.SAX_530, Alphabet.SAX_531, Alphabet.SAX_532, Alphabet.SAX_533, 
				 Alphabet.SAX_534, Alphabet.SAX_535, Alphabet.SAX_536, Alphabet.SAX_537, Alphabet.SAX_538, Alphabet.SAX_539, Alphabet.SAX_540, Alphabet.SAX_541, Alphabet.SAX_542, Alphabet.SAX_543, Alphabet.SAX_544, Alphabet.SAX_545, 
				 Alphabet.SAX_546, Alphabet.SAX_547, Alphabet.SAX_548, Alphabet.SAX_549, Alphabet.SAX_550, Alphabet.SAX_551, Alphabet.SAX_552, Alphabet.SAX_553, Alphabet.SAX_554, Alphabet.SAX_555, Alphabet.SAX_556, Alphabet.SAX_557, 
				 Alphabet.SAX_558, Alphabet.SAX_559, Alphabet.SAX_560, Alphabet.SAX_561, Alphabet.SAX_562, Alphabet.SAX_563, Alphabet.SAX_564, Alphabet.SAX_565, Alphabet.SAX_566, Alphabet.SAX_567, Alphabet.SAX_568, Alphabet.SAX_569, 
				 Alphabet.SAX_570, Alphabet.SAX_571, Alphabet.SAX_572, Alphabet.SAX_573, Alphabet.SAX_574, Alphabet.SAX_575, Alphabet.SAX_576, Alphabet.SAX_577, Alphabet.SAX_578, Alphabet.SAX_579, Alphabet.SAX_580, Alphabet.SAX_581, 
				 Alphabet.SAX_582, Alphabet.SAX_583, Alphabet.SAX_584, Alphabet.SAX_585, Alphabet.SAX_586, Alphabet.SAX_587, Alphabet.SAX_588, Alphabet.SAX_589, Alphabet.SAX_590, Alphabet.SAX_591, Alphabet.SAX_592, Alphabet.SAX_593, 
				 Alphabet.SAX_594, Alphabet.SAX_595, Alphabet.SAX_596, Alphabet.SAX_597, Alphabet.SAX_598, Alphabet.SAX_599, Alphabet.SAX_600, Alphabet.SAX_601, Alphabet.SAX_602, Alphabet.SAX_603, Alphabet.SAX_604, Alphabet.SAX_605, 
				 Alphabet.SAX_606, Alphabet.SAX_607, Alphabet.SAX_608, Alphabet.SAX_609, Alphabet.SAX_610, Alphabet.SAX_611, Alphabet.SAX_612, Alphabet.SAX_613, Alphabet.SAX_614, Alphabet.SAX_615, Alphabet.SAX_616, Alphabet.SAX_617, 
				 Alphabet.SAX_618, Alphabet.SAX_619, Alphabet.SAX_620, Alphabet.SAX_621, Alphabet.SAX_622, Alphabet.SAX_623, Alphabet.SAX_624, Alphabet.SAX_625, Alphabet.SAX_626, Alphabet.SAX_627, Alphabet.SAX_628, Alphabet.SAX_629, 
				 Alphabet.SAX_630, Alphabet.SAX_631, Alphabet.SAX_632, Alphabet.SAX_633, Alphabet.SAX_634, Alphabet.SAX_635, Alphabet.SAX_636, Alphabet.SAX_637, Alphabet.SAX_638, Alphabet.SAX_639, Alphabet.SAX_640, Alphabet.SAX_641, 
				 Alphabet.SAX_642, Alphabet.SAX_643, Alphabet.SAX_644, Alphabet.SAX_645, Alphabet.SAX_646, Alphabet.SAX_647, Alphabet.SAX_648, Alphabet.SAX_649, Alphabet.SAX_650, Alphabet.SAX_651, Alphabet.SAX_652, Alphabet.SAX_653, 
				 Alphabet.SAX_654, Alphabet.SAX_655, Alphabet.SAX_656, Alphabet.SAX_657, Alphabet.SAX_658, Alphabet.SAX_659, Alphabet.SAX_660, Alphabet.SAX_661, Alphabet.SAX_662, Alphabet.SAX_663, Alphabet.SAX_664, Alphabet.SAX_665, 
				 Alphabet.SAX_666, Alphabet.SAX_667, Alphabet.SAX_668, Alphabet.SAX_669, Alphabet.SAX_670, Alphabet.SAX_671, Alphabet.SAX_672, Alphabet.SAX_673, Alphabet.SAX_674, Alphabet.SAX_675, Alphabet.SAX_676, Alphabet.SAX_677, 
				 Alphabet.SAX_678, Alphabet.SAX_679, Alphabet.SAX_680, Alphabet.SAX_681, Alphabet.SAX_682, Alphabet.SAX_683, Alphabet.SAX_684, Alphabet.SAX_685, Alphabet.SAX_686, Alphabet.SAX_687, Alphabet.SAX_688, Alphabet.SAX_689, 
				 Alphabet.SAX_690, Alphabet.SAX_691, Alphabet.SAX_692, Alphabet.SAX_693, Alphabet.SAX_694, Alphabet.SAX_695, Alphabet.SAX_696, Alphabet.SAX_697, Alphabet.SAX_698, Alphabet.SAX_699, Alphabet.SAX_700, Alphabet.SAX_701, 
				 Alphabet.SAX_702, Alphabet.SAX_703, Alphabet.SAX_704, Alphabet.SAX_705, Alphabet.SAX_706, Alphabet.SAX_707, Alphabet.SAX_708, Alphabet.SAX_709, Alphabet.SAX_710, Alphabet.SAX_711, Alphabet.SAX_712, Alphabet.SAX_713, 
				 Alphabet.SAX_714, Alphabet.SAX_715, Alphabet.SAX_716, Alphabet.SAX_717, Alphabet.SAX_718, Alphabet.SAX_719, Alphabet.SAX_720, Alphabet.SAX_721, Alphabet.SAX_722, Alphabet.SAX_723, Alphabet.SAX_724, Alphabet.SAX_725, 
				 Alphabet.SAX_726, Alphabet.SAX_727, Alphabet.SAX_728, Alphabet.SAX_729, Alphabet.SAX_730, Alphabet.SAX_731, Alphabet.SAX_732, Alphabet.SAX_733, Alphabet.SAX_734, Alphabet.SAX_735, Alphabet.SAX_736, Alphabet.SAX_737, 
				 Alphabet.SAX_738, Alphabet.SAX_739, Alphabet.SAX_740, Alphabet.SAX_741, Alphabet.SAX_742, Alphabet.SAX_743, Alphabet.SAX_744, Alphabet.SAX_745, Alphabet.SAX_746, Alphabet.SAX_747, Alphabet.SAX_748, Alphabet.SAX_749, 
				 Alphabet.SAX_750, Alphabet.SAX_751, Alphabet.SAX_752, Alphabet.SAX_753, Alphabet.SAX_754, Alphabet.SAX_755, Alphabet.SAX_756, Alphabet.SAX_757, Alphabet.SAX_758, Alphabet.SAX_759, Alphabet.SAX_760, Alphabet.SAX_761, 
				 Alphabet.SAX_762, Alphabet.SAX_763, Alphabet.SAX_764, Alphabet.SAX_765, Alphabet.SAX_766, Alphabet.SAX_767, Alphabet.SAX_768, Alphabet.SAX_769, Alphabet.SAX_770, Alphabet.SAX_771, Alphabet.SAX_772, Alphabet.SAX_773, 
				 Alphabet.SAX_774, Alphabet.SAX_775, Alphabet.SAX_776, Alphabet.SAX_777, Alphabet.SAX_778, Alphabet.SAX_779, Alphabet.SAX_780, Alphabet.SAX_781, Alphabet.SAX_782, Alphabet.SAX_783, Alphabet.SAX_784, Alphabet.SAX_785, 
				 Alphabet.SAX_786, Alphabet.SAX_787, Alphabet.SAX_788, Alphabet.SAX_789, Alphabet.SAX_790, Alphabet.SAX_791, Alphabet.SAX_792, Alphabet.SAX_793, Alphabet.SAX_794, Alphabet.SAX_795, Alphabet.SAX_796, Alphabet.SAX_797, 
				 Alphabet.SAX_798, Alphabet.SAX_799, Alphabet.SAX_800, Alphabet.SAX_801, Alphabet.SAX_802, Alphabet.SAX_803, Alphabet.SAX_804, Alphabet.SAX_805, Alphabet.SAX_806, Alphabet.SAX_807, Alphabet.SAX_808, Alphabet.SAX_809, 
				 Alphabet.SAX_810, Alphabet.SAX_811, Alphabet.SAX_812, Alphabet.SAX_813, Alphabet.SAX_814, Alphabet.SAX_815, Alphabet.SAX_816, Alphabet.SAX_817, Alphabet.SAX_818, Alphabet.SAX_819, Alphabet.SAX_820, Alphabet.SAX_821, 
				 Alphabet.SAX_822, Alphabet.SAX_823, Alphabet.SAX_824, Alphabet.SAX_825, Alphabet.SAX_826, Alphabet.SAX_827, Alphabet.SAX_828, Alphabet.SAX_829, Alphabet.SAX_830, Alphabet.SAX_831, Alphabet.SAX_832, Alphabet.SAX_833, 
				 Alphabet.SAX_834, Alphabet.SAX_835, Alphabet.SAX_836, Alphabet.SAX_837, Alphabet.SAX_838, Alphabet.SAX_839, Alphabet.SAX_840, Alphabet.SAX_841, Alphabet.SAX_842, Alphabet.SAX_843, Alphabet.SAX_844, Alphabet.SAX_845, 
				 Alphabet.SAX_846, Alphabet.SAX_847, Alphabet.SAX_848, Alphabet.SAX_849, Alphabet.SAX_850, Alphabet.SAX_851, Alphabet.SAX_852, Alphabet.SAX_853, Alphabet.SAX_854, Alphabet.SAX_855, Alphabet.SAX_856, Alphabet.SAX_857, 
				 Alphabet.SAX_858, Alphabet.SAX_859, Alphabet.SAX_860, Alphabet.SAX_861, Alphabet.SAX_862, Alphabet.SAX_863, Alphabet.SAX_864, Alphabet.SAX_865, Alphabet.SAX_866, Alphabet.SAX_867, Alphabet.SAX_868, Alphabet.SAX_869, 
				 Alphabet.SAX_870, Alphabet.SAX_871, Alphabet.SAX_872, Alphabet.SAX_873, Alphabet.SAX_874, Alphabet.SAX_875, Alphabet.SAX_876, Alphabet.SAX_877, Alphabet.SAX_878, Alphabet.SAX_879, Alphabet.SAX_880, Alphabet.SAX_881, 
				 Alphabet.SAX_882, Alphabet.SAX_883, Alphabet.SAX_884, Alphabet.SAX_885, Alphabet.SAX_886, Alphabet.SAX_887, Alphabet.SAX_888, Alphabet.SAX_889, Alphabet.SAX_890, Alphabet.SAX_891, Alphabet.SAX_892, Alphabet.SAX_893, 
				 Alphabet.SAX_894, Alphabet.SAX_895, Alphabet.SAX_896, Alphabet.SAX_897, Alphabet.SAX_898, Alphabet.SAX_899, Alphabet.SAX_900, Alphabet.SAX_901, Alphabet.SAX_902, Alphabet.SAX_903, Alphabet.SAX_904, Alphabet.SAX_905, 
				 Alphabet.SAX_906, Alphabet.SAX_907, Alphabet.SAX_908, Alphabet.SAX_909, Alphabet.SAX_910, Alphabet.SAX_911, Alphabet.SAX_912, Alphabet.SAX_913, Alphabet.SAX_914, Alphabet.SAX_915, Alphabet.SAX_916, Alphabet.SAX_917, 
				 Alphabet.SAX_918, Alphabet.SAX_919, Alphabet.SAX_920, Alphabet.SAX_921, Alphabet.SAX_922, Alphabet.SAX_923, Alphabet.SAX_924, Alphabet.SAX_925, Alphabet.SAX_926, Alphabet.SAX_927, Alphabet.SAX_928, Alphabet.SAX_929, 
				 Alphabet.SAX_930, Alphabet.SAX_931, Alphabet.SAX_932, Alphabet.SAX_933, Alphabet.SAX_934, Alphabet.SAX_935, Alphabet.SAX_936, Alphabet.SAX_937, Alphabet.SAX_938, Alphabet.SAX_939, Alphabet.SAX_940, Alphabet.SAX_941, 
				 Alphabet.SAX_942, Alphabet.SAX_943, Alphabet.SAX_944, Alphabet.SAX_945, Alphabet.SAX_946, Alphabet.SAX_947, Alphabet.SAX_948, Alphabet.SAX_949, Alphabet.SAX_950, Alphabet.SAX_951, Alphabet.SAX_952, Alphabet.SAX_953, 
				 Alphabet.SAX_954, Alphabet.SAX_955, Alphabet.SAX_956, Alphabet.SAX_957, Alphabet.SAX_958, Alphabet.SAX_959, Alphabet.SAX_960, Alphabet.SAX_961, Alphabet.SAX_962, Alphabet.SAX_963, Alphabet.SAX_964, Alphabet.SAX_965, 
				 Alphabet.SAX_966, Alphabet.SAX_967, Alphabet.SAX_968, Alphabet.SAX_969, Alphabet.SAX_970, Alphabet.SAX_971, Alphabet.SAX_972, Alphabet.SAX_973, Alphabet.SAX_974, Alphabet.SAX_975, Alphabet.SAX_976, Alphabet.SAX_977, 
				 Alphabet.SAX_978, Alphabet.SAX_979, Alphabet.SAX_980, Alphabet.SAX_981, Alphabet.SAX_982, Alphabet.SAX_983, Alphabet.SAX_984, Alphabet.SAX_985, Alphabet.SAX_986, Alphabet.SAX_987, Alphabet.SAX_988, Alphabet.SAX_989, 
				 Alphabet.SAX_990, Alphabet.SAX_991, Alphabet.SAX_992, Alphabet.SAX_993, Alphabet.SAX_994, Alphabet.SAX_995, Alphabet.SAX_996, Alphabet.SAX_997, Alphabet.SAX_998, Alphabet.SAX_999, Alphabet.SAX_1000, Alphabet.SAX_1001, 
				 Alphabet.SAX_1002, Alphabet.SAX_1003, Alphabet.SAX_1004, Alphabet.SAX_1005, Alphabet.SAX_1006, Alphabet.SAX_1007, Alphabet.SAX_1008, Alphabet.SAX_1009, Alphabet.SAX_1010, Alphabet.SAX_1011, Alphabet.SAX_1012, 
				 Alphabet.SAX_1013, Alphabet.SAX_1014, Alphabet.SAX_1015, Alphabet.SAX_1016, Alphabet.SAX_1017, Alphabet.SAX_1018, Alphabet.SAX_1019, Alphabet.SAX_1020, Alphabet.SAX_1021, Alphabet.SAX_1022, Alphabet.SAX_1023, 
				 Alphabet.SAX_1024};


	public static Alphabet getSaxAlphabet(int index) {
		return alphabet[index - 2];
	}


	// The cuts are the limits of each SAX letter for a given alphabet
	/*
	protected static double[][] cuts = {
		{0},
		{-0.430727,0.430727},
		{-0.67449,0,0.67449},
		{-0.841621,-0.253347,0.253347,0.841621},
		{-0.967422,-0.430727,0,0.430727,0.967422},
		{-1.06757,-0.565949,-0.180012,0.180012,0.565949,1.06757},
		{-1.15035,-0.67449,-0.318639,0,0.318639,0.67449,1.15035},
		{-1.22064,-0.76471,-0.430727,-0.13971,0.13971,0.430727,0.76471,1.22064},
		{-1.28155,-0.841621,-0.524401,-0.253347,0,0.253347,0.524401,0.841621,1.28155},
		{-1.33518,-0.908458,-0.604585,-0.348756,-0.114185,0.114185,0.348756,0.604585,
		 0.908458,1.33518},
		{-1.38299,-0.967422,-0.67449,-0.430727,-0.210428,-1.39146e-16,0.210428,0.430727,
		 0.67449,0.967422,1.38299},
		{-1.42608,-1.02008,-0.736316,-0.502402,-0.293381,-0.0965586,0.0965586,0.293381,
		 0.502402,0.736316,1.02008,1.42608},
		{-1.46523,-1.06757,-0.791639,-0.565949,-0.366106,-0.180012,-2.78292e-16,0.180012,
		 0.366106,0.565949,0.791639,1.06757,1.46523},
		{-1.50109,-1.11077,-0.841621,-0.622926,-0.430727,-0.253347,-0.0836517,0.0836517,
		 0.253347,0.430727,0.622926,0.841621,1.11077,1.50109},
		{-1.53412,-1.15035,-0.887147,-0.67449,-0.488776,-0.318639,-0.157311,0,0.157311,
		 0.318639,0.488776,0.67449,0.887147,1.15035,1.53412}
	};
	*/

	protected static double [][] cuts = readCuts();

	public static short getSaxLetter(Alphabet alpha, double value) {
		double [] c = cuts[alpha.ordinal()];
		int sax = BinarySearch.findIndex(c, value);
		return (short) sax;
	};
	public static int space(Alphabet alpha) {
		return alpha.ordinal() + 2;
	};

	public static double [][] readCuts()
	{
		try {
  			InputStream is = SaxAlphabet.class.getResourceAsStream("/sax_cuts.csv");
  			InputStreamReader isr = new InputStreamReader(is);
  			BufferedReader br = new BufferedReader(isr);
  			ArrayList<double []> list = new ArrayList();
  			String line;
  			while ((line = br.readLine()) != null) 
  			{
			  	String [] strs = line.split(",");
    			double [] vals = new double[strs.length];

				for (int i = 0; i < strs.length; i++) {
					vals[i] = Double.parseDouble(strs[i]);
				}

				list.add(vals);
 			}
  			br.close();
  			isr.close();
  			is.close();

			double [][] result = new double[list.size()][];
			
  			return list.toArray(result);
		}
		catch(Throwable e) {
			System.err.printf(e.getMessage());
			System.exit(-1);
			return null;
		}
	}

	public static void main(String [] args) {
		BigInteger encoded = BigInteger.valueOf(123456789L);
		SaxWord word = new SaxWord(Alphabet.SAX_10, 9, encoded);
		BigInteger recoded = word.getSaxInt();
		System.err.printf("Word: %d\n", recoded.longValue());
	}
};
		
	
	
