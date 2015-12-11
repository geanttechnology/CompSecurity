.class public Lcom/amazon/device/ads/AdActivity;
.super Landroid/app/Activity;
.source "AdActivity.java"


# static fields
.field protected static final ADAPTER_KEY:Ljava/lang/String; = "adapter"

.field private static final LOG_TAG:Ljava/lang/String; = "AdAdapter"


# instance fields
.field private adapter:Lcom/amazon/device/ads/IAdActivityAdapter;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method createAdapter()Lcom/amazon/device/ads/IAdActivityAdapter;
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 45
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdActivity;->getIntent()Landroid/content/Intent;

    move-result-object v6

    const-string/jumbo v7, "adapter"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "adapterClassName":Ljava/lang/String;
    if-nez v2, :cond_0

    .line 48
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "Unable to launch the AdActivity due to an internal error."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 105
    :goto_0
    return-object v0

    .line 52
    :cond_0
    const/4 v1, 0x0

    .line 55
    .local v1, "adapterClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :try_start_0
    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 63
    const/4 v3, 0x0

    .line 66
    .local v3, "adapterConstructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    const/4 v6, 0x0

    :try_start_1
    new-array v6, v6, [Ljava/lang/Class;

    invoke-virtual {v1, v6}, Ljava/lang/Class;->getDeclaredConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v3

    .line 79
    const/4 v0, 0x0

    .line 82
    .local v0, "adapter":Lcom/amazon/device/ads/IAdActivityAdapter;
    const/4 v6, 0x0

    :try_start_2
    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v3, v6}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "adapter":Lcom/amazon/device/ads/IAdActivityAdapter;
    check-cast v0, Lcom/amazon/device/ads/IAdActivityAdapter;
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/InstantiationException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/lang/IllegalAccessException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_2 .. :try_end_2} :catch_6

    .restart local v0    # "adapter":Lcom/amazon/device/ads/IAdActivityAdapter;
    goto :goto_0

    .line 57
    .end local v0    # "adapter":Lcom/amazon/device/ads/IAdActivityAdapter;
    .end local v3    # "adapterConstructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    :catch_0
    move-exception v4

    .line 59
    .local v4, "e":Ljava/lang/ClassNotFoundException;
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "Unable to get the adapter class."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 60
    goto :goto_0

    .line 68
    .end local v4    # "e":Ljava/lang/ClassNotFoundException;
    .restart local v3    # "adapterConstructor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<*>;"
    :catch_1
    move-exception v4

    .line 70
    .local v4, "e":Ljava/lang/SecurityException;
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "Security exception when trying to get the default constructor."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 71
    goto :goto_0

    .line 73
    .end local v4    # "e":Ljava/lang/SecurityException;
    :catch_2
    move-exception v4

    .line 75
    .local v4, "e":Ljava/lang/NoSuchMethodException;
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "No default constructor exists for the adapter."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 76
    goto :goto_0

    .line 84
    .end local v4    # "e":Ljava/lang/NoSuchMethodException;
    :catch_3
    move-exception v4

    .line 86
    .local v4, "e":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "Illegal arguments given to the default constructor."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 87
    goto :goto_0

    .line 89
    .end local v4    # "e":Ljava/lang/IllegalArgumentException;
    :catch_4
    move-exception v4

    .line 91
    .local v4, "e":Ljava/lang/InstantiationException;
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "Instantiation exception when instantiating the adapter."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 92
    goto :goto_0

    .line 94
    .end local v4    # "e":Ljava/lang/InstantiationException;
    :catch_5
    move-exception v4

    .line 96
    .local v4, "e":Ljava/lang/IllegalAccessException;
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "Illegal access exception when instantiating the adapter."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 97
    goto :goto_0

    .line 99
    .end local v4    # "e":Ljava/lang/IllegalAccessException;
    :catch_6
    move-exception v4

    .line 101
    .local v4, "e":Ljava/lang/reflect/InvocationTargetException;
    const-string/jumbo v6, "AdAdapter"

    const-string/jumbo v7, "Invocation target exception when instantiating the adapter."

    invoke-static {v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v5

    .line 102
    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AdActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/IInternalAdRegistration;->contextReceived(Landroid/content/Context;)V

    .line 29
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdActivity;->createAdapter()Lcom/amazon/device/ads/IAdActivityAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    .line 30
    iget-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    if-nez v0, :cond_0

    .line 32
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdActivity;->finish()V

    .line 41
    :goto_0
    return-void

    .line 35
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/IAdActivityAdapter;->setActivity(Landroid/app/Activity;)V

    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdActivityAdapter;->preOnCreate()V

    .line 38
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 40
    iget-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdActivityAdapter;->onCreate()V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 111
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 112
    iget-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdActivityAdapter;->onPause()V

    .line 113
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 118
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 119
    iget-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdActivityAdapter;->onResume()V

    .line 120
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/amazon/device/ads/AdActivity;->adapter:Lcom/amazon/device/ads/IAdActivityAdapter;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdActivityAdapter;->onStop()V

    .line 126
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 127
    return-void
.end method
