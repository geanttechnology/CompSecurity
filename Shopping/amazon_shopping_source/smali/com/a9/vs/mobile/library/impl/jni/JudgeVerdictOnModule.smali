.class public final enum Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
.super Ljava/lang/Enum;
.source "JudgeVerdictOnModule.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseEnoughTimeExpired:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseFocusHasImproved:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseImageScaleHasChanged:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseModuleNeverRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseObjectModuleIsActive:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameApprovedBecauseTrackerHasDetectedSufficientMotion:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameStatusIsUnknown:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameVetoedBecauseAlreadyRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameVetoedBecauseCachedImageIsBetter:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameVetoedBecauseFrameUnexpectedlyNull:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameVetoedBecauseNoApprovalTestsSucceeded:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum FrameVetoedBecauseOfUnexpectedError:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

.field public static final enum NUM_FRAME_JUDGE_VERVICTS:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;


# instance fields
.field private final swigValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 12
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameVetoedBecauseFrameUnexpectedlyNull"

    invoke-direct {v0, v1, v3, v3}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseFrameUnexpectedlyNull:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 13
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull"

    invoke-direct {v0, v1, v4}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 14
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameVetoedBecauseOfUnexpectedError"

    invoke-direct {v0, v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseOfUnexpectedError:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 15
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameVetoedBecauseAlreadyRun"

    invoke-direct {v0, v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseAlreadyRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 16
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameVetoedBecauseNoApprovalTestsSucceeded"

    invoke-direct {v0, v1, v7}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseNoApprovalTestsSucceeded:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 17
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameVetoedBecauseCachedImageIsBetter"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseCachedImageIsBetter:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 18
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseModuleNeverRun"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseModuleNeverRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 19
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseObjectModuleIsActive"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseObjectModuleIsActive:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 20
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseEnoughTimeExpired"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseEnoughTimeExpired:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 21
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 22
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseTrackerHasDetectedSufficientMotion"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseTrackerHasDetectedSufficientMotion:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 23
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseFocusHasImproved"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseFocusHasImproved:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 24
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseImageScaleHasChanged"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseImageScaleHasChanged:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 25
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 26
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "FrameStatusIsUnknown"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameStatusIsUnknown:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 27
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    const-string/jumbo v1, "NUM_FRAME_JUDGE_VERVICTS"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->NUM_FRAME_JUDGE_VERVICTS:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 11
    const/16 v0, 0x10

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseFrameUnexpectedlyNull:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseCherryPickedFrameUnexpectedlyNull:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseOfUnexpectedError:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseAlreadyRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v1, v0, v6

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseNoApprovalTestsSucceeded:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameVetoedBecauseCachedImageIsBetter:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseModuleNeverRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseObjectModuleIsActive:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseEnoughTimeExpired:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseHistogramSufficientlyDifferentFromLastRun:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseTrackerHasDetectedSufficientMotion:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseFocusHasImproved:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseImageScaleHasChanged:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameApprovedBecauseAffineCanvasImageIsSufficientlyNovel:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->FrameStatusIsUnknown:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->NUM_FRAME_JUDGE_VERVICTS:Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    aput-object v2, v0, v1

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 45
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    .line 46
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 1
    .param p3, "swigValue"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 50
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    .line 51
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule$SwigNext;->access$002(I)I

    .line 52
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;",
            ")V"
        }
    .end annotation

    .prologue
    .line 55
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 56
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    .line 57
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule$SwigNext;->access$002(I)I

    .line 58
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 34
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    .line 35
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 36
    aget-object v3, v4, p0

    .line 39
    :cond_0
    return-object v3

    .line 37
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 38
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 37
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 40
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " with value "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/JudgeVerdictOnModule;->swigValue:I

    return v0
.end method
