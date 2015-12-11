.class Lcom/amazon/android/webkit/android/ClientApiLevel;
.super Ljava/lang/Object;
.source "ClientApiLevel.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static instance:Lcom/amazon/android/webkit/android/ClientApiLevel;


# instance fields
.field private apiLevel:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/android/webkit/android/ClientApiLevel;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/ClientApiLevel;->TAG:Ljava/lang/String;

    .line 18
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/android/webkit/android/ClientApiLevel;->instance:Lcom/amazon/android/webkit/android/ClientApiLevel;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    return-void
.end method

.method static getInstance()Lcom/amazon/android/webkit/android/ClientApiLevel;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/amazon/android/webkit/android/ClientApiLevel;->instance:Lcom/amazon/android/webkit/android/ClientApiLevel;

    return-object v0
.end method

.method static initialize()V
    .locals 2

    .prologue
    .line 50
    new-instance v0, Lcom/amazon/android/webkit/android/ClientApiLevel;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/ClientApiLevel;-><init>()V

    sput-object v0, Lcom/amazon/android/webkit/android/ClientApiLevel;->instance:Lcom/amazon/android/webkit/android/ClientApiLevel;

    .line 52
    sget-object v0, Lcom/amazon/android/webkit/android/ClientApiLevel;->instance:Lcom/amazon/android/webkit/android/ClientApiLevel;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/android/webkit/android/ClientApiLevel;->setApiLevel(I)V

    .line 53
    return-void
.end method


# virtual methods
.method getApiLevel()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/amazon/android/webkit/android/ClientApiLevel;->apiLevel:I

    return v0
.end method

.method setApiLevel(I)V
    .locals 3
    .param p1, "apiLevel"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 42
    const/4 v0, 0x1

    if-lt p1, v0, :cond_0

    const/4 v0, 0x4

    if-le p1, v0, :cond_1

    .line 43
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Invalid apiLevel ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_1
    iput p1, p0, Lcom/amazon/android/webkit/android/ClientApiLevel;->apiLevel:I

    .line 46
    sget-object v0, Lcom/amazon/android/webkit/android/ClientApiLevel;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Client API Level:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 47
    return-void
.end method
