.class public final enum Lcom/a9/vs/mobile/library/impl/jni/ActionID;
.super Ljava/lang/Enum;
.source "ActionID.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ActionID$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/ActionID;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum DECODE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum DETECT:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum FRAME_PROCESS:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum NUM_ACTIONS:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum RECEIVE_RESPONSE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum REDETECT:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum SCHEDULE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum SCREEN:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum SEND_REQUEST:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum TRACK:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum UNSPECIFIED_ACTION:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

.field public static final enum VERIFY:Lcom/a9/vs/mobile/library/impl/jni/ActionID;


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
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "FRAME_PROCESS"

    invoke-direct {v0, v1, v3, v3}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->FRAME_PROCESS:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 13
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "SCREEN"

    invoke-direct {v0, v1, v4}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->SCREEN:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 14
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "SCHEDULE"

    invoke-direct {v0, v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->SCHEDULE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 15
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "DETECT"

    invoke-direct {v0, v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->DETECT:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 16
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "DECODE"

    invoke-direct {v0, v1, v7}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->DECODE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 17
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "TRACK"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->TRACK:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 18
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "VERIFY"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->VERIFY:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 19
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "REDETECT"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->REDETECT:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 20
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "SEND_REQUEST"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->SEND_REQUEST:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 21
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "RECEIVE_RESPONSE"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->RECEIVE_RESPONSE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 22
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "UNSPECIFIED_ACTION"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->UNSPECIFIED_ACTION:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 23
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    const-string/jumbo v1, "NUM_ACTIONS"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ActionID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->NUM_ACTIONS:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 11
    const/16 v0, 0xc

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->FRAME_PROCESS:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->SCREEN:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->SCHEDULE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->DETECT:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v1, v0, v6

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->DECODE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->TRACK:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->VERIFY:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->REDETECT:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->SEND_REQUEST:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->RECEIVE_RESPONSE:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->UNSPECIFIED_ACTION:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->NUM_ACTIONS:Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    aput-object v2, v0, v1

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ActionID;

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
    .line 40
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 41
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/ActionID$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/ActionID$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    .line 42
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
    .line 45
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 46
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    .line 47
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ActionID$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ActionID$SwigNext;->access$002(I)I

    .line 48
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/ActionID;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ActionID;",
            ")V"
        }
    .end annotation

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 52
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    .line 53
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ActionID$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ActionID$SwigNext;->access$002(I)I

    .line 54
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 30
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    .line 31
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 32
    aget-object v3, v4, p0

    .line 35
    :cond_0
    return-object v3

    .line 33
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 34
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 33
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 36
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

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

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/ActionID;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/ActionID;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/ActionID;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 26
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ActionID;->swigValue:I

    return v0
.end method
