.class public final enum Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
.super Ljava/lang/Enum;
.source "ObjectID.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ObjectID$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/ObjectID;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum DEEP_LEARNING:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum IMGMATCHOBJ:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum LOGO:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum NUM_OBJECTS:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum TEXT:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum TEXTCANVAS:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum TWOD_BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

.field public static final enum UNSPECIFIED_OBJECT:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;


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
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "IMGMATCHOBJ"

    invoke-direct {v0, v1, v3, v3}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->IMGMATCHOBJ:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 13
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "BARCODE"

    invoke-direct {v0, v1, v4}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 14
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "TWOD_BARCODE"

    invoke-direct {v0, v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TWOD_BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 15
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "TEXT"

    invoke-direct {v0, v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TEXT:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 16
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "TEXTCANVAS"

    invoke-direct {v0, v1, v7}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TEXTCANVAS:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 17
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "LOGO"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->LOGO:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 18
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "DEEP_LEARNING"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->DEEP_LEARNING:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 19
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "UNSPECIFIED_OBJECT"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->UNSPECIFIED_OBJECT:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 20
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    const-string/jumbo v1, "NUM_OBJECTS"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->NUM_OBJECTS:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 11
    const/16 v0, 0x9

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->IMGMATCHOBJ:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TWOD_BARCODE:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TEXT:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v1, v0, v6

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->TEXTCANVAS:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->LOGO:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->DEEP_LEARNING:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->UNSPECIFIED_OBJECT:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->NUM_OBJECTS:Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    aput-object v2, v0, v1

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

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
    .line 37
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 38
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/ObjectID$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    .line 39
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
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 43
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    .line 44
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ObjectID$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID$SwigNext;->access$002(I)I

    .line 45
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/ObjectID;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ObjectID;",
            ")V"
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 49
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    .line 50
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ObjectID$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID$SwigNext;->access$002(I)I

    .line 51
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 27
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    .line 28
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 29
    aget-object v3, v4, p0

    .line 32
    :cond_0
    return-object v3

    .line 30
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 31
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 30
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 33
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

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

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 23
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->swigValue:I

    return v0
.end method
