.class Lcom/exacttarget/etpushsdk/util/EventBus$a;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public a:Ljava/lang/Object;

.field public b:Ljava/lang/reflect/Method;

.field final synthetic c:Lcom/exacttarget/etpushsdk/util/EventBus;


# direct methods
.method private constructor <init>(Lcom/exacttarget/etpushsdk/util/EventBus;Ljava/lang/Object;Ljava/lang/reflect/Method;)V
    .locals 0

    .prologue
    .line 217
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/util/EventBus$a;->c:Lcom/exacttarget/etpushsdk/util/EventBus;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 218
    iput-object p2, p0, Lcom/exacttarget/etpushsdk/util/EventBus$a;->a:Ljava/lang/Object;

    .line 219
    iput-object p3, p0, Lcom/exacttarget/etpushsdk/util/EventBus$a;->b:Ljava/lang/reflect/Method;

    .line 220
    return-void
.end method

.method synthetic constructor <init>(Lcom/exacttarget/etpushsdk/util/EventBus;Ljava/lang/Object;Ljava/lang/reflect/Method;Lcom/exacttarget/etpushsdk/util/EventBus$1;)V
    .locals 0

    .prologue
    .line 213
    invoke-direct {p0, p1, p2, p3}, Lcom/exacttarget/etpushsdk/util/EventBus$a;-><init>(Lcom/exacttarget/etpushsdk/util/EventBus;Ljava/lang/Object;Ljava/lang/reflect/Method;)V

    return-void
.end method
