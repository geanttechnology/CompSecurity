.class public abstract Lcom/amazon/android/dagger/application/DaggerApplication;
.super Landroid/app/Application;
.source "DaggerApplication.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract configure(Ljava/util/Set;)Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end method

.method createGraph(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    invoke-virtual {p0, v1}, Lcom/amazon/android/dagger/application/DaggerApplication;->configure(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    .line 44
    .local v0, "modules":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Object;>;"
    new-instance v1, Lcom/amazon/android/dagger/application/ContextModule;

    invoke-direct {v1, p1}, Lcom/amazon/android/dagger/application/ContextModule;-><init>(Landroid/content/Context;)V

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 45
    invoke-interface {v0}, Ljava/util/Set;->toArray()[Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/android/dagger/DaggerAndroid;->createGraph([Ljava/lang/Object;)Ldagger/ObjectGraph;

    .line 46
    return-void
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/android/dagger/application/DaggerApplication;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/android/dagger/application/DaggerApplication;->createGraph(Landroid/content/Context;)V

    .line 24
    return-void
.end method
