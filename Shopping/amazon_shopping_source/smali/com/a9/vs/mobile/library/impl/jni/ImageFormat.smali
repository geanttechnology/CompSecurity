.class public final enum Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
.super Ljava/lang/Enum;
.source "ImageFormat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ImageFormat$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

.field public static final enum BGR:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

.field public static final enum BGRA:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

.field public static final enum RGB565:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

.field public static final enum UNKNOWN_FORMAT:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

.field public static final enum YUV420_NV12:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

.field public static final enum YUV420_NV21:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;


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
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    const-string/jumbo v1, "YUV420_NV21"

    invoke-direct {v0, v1, v3, v3}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->YUV420_NV21:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .line 13
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    const-string/jumbo v1, "YUV420_NV12"

    invoke-direct {v0, v1, v4}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->YUV420_NV12:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .line 14
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    const-string/jumbo v1, "BGRA"

    invoke-direct {v0, v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->BGRA:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .line 15
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    const-string/jumbo v1, "RGB565"

    invoke-direct {v0, v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->RGB565:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .line 16
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    const-string/jumbo v1, "BGR"

    invoke-direct {v0, v1, v7}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->BGR:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .line 17
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    const-string/jumbo v1, "UNKNOWN_FORMAT"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->UNKNOWN_FORMAT:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .line 11
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->YUV420_NV21:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->YUV420_NV12:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->BGRA:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->RGB565:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    aput-object v1, v0, v6

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->BGR:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->UNKNOWN_FORMAT:Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    aput-object v2, v0, v1

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

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
    .line 34
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 35
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/ImageFormat$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    .line 36
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
    .line 39
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 40
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    .line 41
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ImageFormat$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat$SwigNext;->access$002(I)I

    .line 42
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/ImageFormat;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;",
            ")V"
        }
    .end annotation

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 46
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    .line 47
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ImageFormat$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat$SwigNext;->access$002(I)I

    .line 48
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 24
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    .line 25
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 26
    aget-object v3, v4, p0

    .line 29
    :cond_0
    return-object v3

    .line 27
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 28
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 27
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 30
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

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

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 20
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ImageFormat;->swigValue:I

    return v0
.end method
