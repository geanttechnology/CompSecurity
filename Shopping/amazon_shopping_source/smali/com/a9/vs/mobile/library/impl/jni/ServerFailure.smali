.class public final enum Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
.super Ljava/lang/Enum;
.source "ServerFailure.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/vs/mobile/library/impl/jni/ServerFailure$SwigNext;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

.field public static final enum NO_NETWORK:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

.field public static final enum NO_SERVER_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

.field public static final enum SERVER_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

.field public static final enum UNAUTHORIZED_ACCESS:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

.field public static final enum UNKNOWN_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;


# instance fields
.field private final swigValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 12
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    const-string/jumbo v1, "NO_SERVER_ERROR"

    invoke-direct {v0, v1, v2, v2}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->NO_SERVER_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .line 13
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    const-string/jumbo v1, "NO_NETWORK"

    invoke-direct {v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->NO_NETWORK:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .line 14
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    const-string/jumbo v1, "UNAUTHORIZED_ACCESS"

    invoke-direct {v0, v1, v4}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->UNAUTHORIZED_ACCESS:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .line 15
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    const-string/jumbo v1, "SERVER_ERROR"

    invoke-direct {v0, v1, v5}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->SERVER_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .line 16
    new-instance v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    const-string/jumbo v1, "UNKNOWN_ERROR"

    invoke-direct {v0, v1, v6}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->UNKNOWN_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .line 11
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->NO_SERVER_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    aput-object v1, v0, v2

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->NO_NETWORK:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->UNAUTHORIZED_ACCESS:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->SERVER_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    aput-object v1, v0, v5

    sget-object v1, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->UNKNOWN_ERROR:Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    aput-object v1, v0, v6

    sput-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

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
    .line 33
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 34
    # operator++ for: Lcom/a9/vs/mobile/library/impl/jni/ServerFailure$SwigNext;->next:I
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure$SwigNext;->access$008()I

    move-result v0

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    .line 35
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
    .line 38
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 39
    iput p3, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    .line 40
    add-int/lit8 v0, p3, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ServerFailure$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure$SwigNext;->access$002(I)I

    .line 41
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/a9/vs/mobile/library/impl/jni/ServerFailure;)V
    .locals 1
    .param p3, "swigEnum"    # Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;",
            ")V"
        }
    .end annotation

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 45
    iget v0, p3, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    iput v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    .line 46
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    add-int/lit8 v0, v0, 0x1

    # setter for: Lcom/a9/vs/mobile/library/impl/jni/ServerFailure$SwigNext;->next:I
    invoke-static {v0}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure$SwigNext;->access$002(I)I

    .line 47
    return-void
.end method

.method public static swigToEnum(I)Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    .locals 8
    .param p0, "swigValue"    # I

    .prologue
    .line 23
    const-class v5, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    invoke-virtual {v5}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .line 24
    .local v4, "swigValues":[Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    array-length v5, v4

    if-ge p0, v5, :cond_1

    if-ltz p0, :cond_1

    aget-object v5, v4, p0

    iget v5, v5, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    if-ne v5, p0, :cond_1

    .line 25
    aget-object v3, v4, p0

    .line 28
    :cond_0
    return-object v3

    .line 26
    :cond_1
    move-object v0, v4

    .local v0, "arr$":[Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_2

    aget-object v3, v0, v1

    .line 27
    .local v3, "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    iget v5, v3, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    if-eq v5, p0, :cond_0

    .line 26
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 29
    .end local v3    # "swigEnum":Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "No enum "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-class v7, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

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

.method public static valueOf(Ljava/lang/String;)Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    return-object v0
.end method

.method public static values()[Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->$VALUES:[Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    invoke-virtual {v0}, [Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    return-object v0
.end method


# virtual methods
.method public final swigValue()I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->swigValue:I

    return v0
.end method
