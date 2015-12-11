.class public Lcom/amazon/retailsearch/client/UiInvocationHandler;
.super Ljava/lang/Object;
.source "UiInvocationHandler.java"

# interfaces
.implements Ljava/lang/reflect/InvocationHandler;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/reflect/InvocationHandler;"
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private final resourceRef:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/retailsearch/client/UiInvocationHandler;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/client/UiInvocationHandler;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p0, "this":Lcom/amazon/retailsearch/client/UiInvocationHandler;, "Lcom/amazon/retailsearch/client/UiInvocationHandler<TT;>;"
    .local p1, "resource":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler;->resourceRef:Ljava/lang/ref/WeakReference;

    .line 33
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/client/UiInvocationHandler;)Ljava/lang/ref/WeakReference;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/client/UiInvocationHandler;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler;->resourceRef:Ljava/lang/ref/WeakReference;

    return-object v0
.end method

.method static synthetic access$100()Lcom/amazon/retailsearch/log/MessageLogger;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/retailsearch/client/UiInvocationHandler;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-object v0
.end method

.method public static createUiProxy(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 74
    .local p0, "obj":Ljava/lang/Object;, "TT;"
    .local p1, "cls":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-virtual {p1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Class;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    new-instance v2, Lcom/amazon/retailsearch/client/UiInvocationHandler;

    invoke-direct {v2, p0}, Lcom/amazon/retailsearch/client/UiInvocationHandler;-><init>(Ljava/lang/Object;)V

    invoke-static {v0, v1, v2}, Ljava/lang/reflect/Proxy;->newProxyInstance(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "proxy"    # Ljava/lang/Object;
    .param p2, "method"    # Ljava/lang/reflect/Method;
    .param p3, "args"    # [Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/amazon/retailsearch/client/UiInvocationHandler;, "Lcom/amazon/retailsearch/client/UiInvocationHandler<TT;>;"
    const/4 v2, 0x0

    .line 41
    iget-object v0, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler;->resourceRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 62
    :goto_0
    return-object v2

    .line 45
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/client/UiInvocationHandler;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v1, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;

    invoke-direct {v1, p0, p2, p3}, Lcom/amazon/retailsearch/client/UiInvocationHandler$1;-><init>(Lcom/amazon/retailsearch/client/UiInvocationHandler;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
