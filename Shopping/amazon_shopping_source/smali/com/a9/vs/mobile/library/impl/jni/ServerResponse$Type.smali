.class public final enum Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
.super Ljava/lang/Enum;
.source "ServerResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/a9/vs/mobile/library/impl/jni/ServerResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field public static final enum JSON_IMGMATCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field public static final enum JSON_LOGO:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field public static final enum JSON_TERS:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field public static final enum JSON_TERS_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field public static final enum JSON_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

.field public static final enum JSON_VSEARCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;


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

    .line 83
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    const-string/jumbo v1, "JSON_TERS"

    invoke-direct {v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TERS:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 84
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    const-string/jumbo v1, "JSON_TR"

    invoke-direct {v0, v1, v4}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 85
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    const-string/jumbo v1, "JSON_TERS_TR"

    invoke-direct {v0, v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TERS_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 86
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    const-string/jumbo v1, "JSON_IMGMATCH"

    invoke-direct {v0, v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_IMGMATCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 87
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    const-string/jumbo v1, "JSON_LOGO"

    invoke-direct {v0, v1, v7}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_LOGO:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 88
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    const-string/jumbo v1, "JSON_VSEARCH"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_VSEARCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 82
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TERS:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_TERS_TR:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_IMGMATCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    aput-object v1, v0, v6

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_LOGO:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->JSON_VSEARCH:Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    aput-object v2, v0, v1

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

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
    .line 105
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 106
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    .line 107
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
    .line 110
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 111
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    .line 112
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type$SwigNext;->access$002(I)I

    .line 113
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;",
            ")V"
        }
    .end annotation

    .prologue
    .line 116
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 117
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    .line 118
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type$SwigNext;->access$002(I)I

    .line 119
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 95
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    .line 96
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 97
    aget-object v3, v4, p0

    .line 100
    :cond_0
    return-object v3

    .line 98
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 99
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 98
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 101
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

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

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 82
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 91
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerResponse$Type;->swigValue:I

    return v0
.end method
