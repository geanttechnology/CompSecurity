.class public final enum Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
.super Ljava/lang/Enum;
.source "ImageDef.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ImageDef$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/ImageDef;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

.field public static final enum FULL_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

.field public static final enum FULL_RES_COLOR:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

.field public static final enum HALF_PROCESS_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

.field public static final enum NUM_IMAGEDEFS:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

.field public static final enum PROCESS_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

.field public static final enum PROCESS_RES_COLOR:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

.field public static final enum TRACKING_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;


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
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    const-string/jumbo v1, "FULL_RES"

    invoke-direct {v0, v1, v3, v3}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->FULL_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 13
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    const-string/jumbo v1, "FULL_RES_COLOR"

    invoke-direct {v0, v1, v4}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->FULL_RES_COLOR:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 14
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    const-string/jumbo v1, "PROCESS_RES"

    invoke-direct {v0, v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->PROCESS_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 15
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    const-string/jumbo v1, "PROCESS_RES_COLOR"

    invoke-direct {v0, v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->PROCESS_RES_COLOR:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 16
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    const-string/jumbo v1, "HALF_PROCESS_RES"

    invoke-direct {v0, v1, v7}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->HALF_PROCESS_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 17
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    const-string/jumbo v1, "TRACKING_RES"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->TRACKING_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 18
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    const-string/jumbo v1, "NUM_IMAGEDEFS"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->NUM_IMAGEDEFS:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 11
    const/4 v0, 0x7

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->FULL_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->FULL_RES_COLOR:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->PROCESS_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->PROCESS_RES_COLOR:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    aput-object v1, v0, v6

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->HALF_PROCESS_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->TRACKING_RES:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->NUM_IMAGEDEFS:Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    aput-object v2, v0, v1

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 36
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/ImageDef$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    .line 37
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
    .line 40
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 41
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    .line 42
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ImageDef$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef$SwigNext;->access$002(I)I

    .line 43
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/ImageDef;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ImageDef;",
            ")V"
        }
    .end annotation

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 47
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    .line 48
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ImageDef$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageDef$SwigNext;->access$002(I)I

    .line 49
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 25
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    .line 26
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 27
    aget-object v3, v4, p0

    .line 30
    :cond_0
    return-object v3

    .line 28
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 29
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 28
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 31
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

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

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/ImageDef;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/ImageDef;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageDef;->swigValue:I

    return v0
.end method
