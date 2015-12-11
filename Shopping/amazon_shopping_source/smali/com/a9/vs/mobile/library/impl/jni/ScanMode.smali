.class public final enum Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
.super Ljava/lang/Enum;
.source "ScanMode.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ScanMode$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/ScanMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

.field public static final enum CONTINUOUS_SCAN:Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

.field public static final enum SINGLE_SCAN:Lcom/a9/vs/mobile/library/impl/jni/ScanMode;


# instance fields
.field private final swigValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 12
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    const-string/jumbo v1, "SINGLE_SCAN"

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->SINGLE_SCAN:Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    .line 13
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    const-string/jumbo v1, "CONTINUOUS_SCAN"

    invoke-direct {v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->CONTINUOUS_SCAN:Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    .line 11
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->SINGLE_SCAN:Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->CONTINUOUS_SCAN:Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    aput-object v1, v0, v3

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

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
    .line 30
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 31
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/ScanMode$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/ScanMode$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    .line 32
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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 36
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    .line 37
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ScanMode$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ScanMode$SwigNext;->access$002(I)I

    .line 38
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/ScanMode;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ScanMode;",
            ")V"
        }
    .end annotation

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 42
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    .line 43
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ScanMode$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ScanMode$SwigNext;->access$002(I)I

    .line 44
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 20
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    .line 21
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 22
    aget-object v3, v4, p0

    .line 25
    :cond_0
    return-object v3

    .line 23
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 24
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 23
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 26
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

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

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/ScanMode;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/ScanMode;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 16
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ScanMode;->swigValue:I

    return v0
.end method
