.class public Lcom/amazon/android/webkit/android/AndroidPluginManager;
.super Ljava/lang/Object;
.source "AndroidPluginManager.java"

# interfaces
.implements Lcom/amazon/android/webkit/AmazonPluginManager;


# static fields
.field private static final GET_INSTANCE:Ljava/lang/reflect/Method;

.field private static final PLUGIN_MANAGER:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private static final REFRESH_PLUGINS:Ljava/lang/reflect/Method;


# instance fields
.field private final receiver:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    .line 17
    :try_start_0
    const-string/jumbo v1, "android.webkit.PluginManager"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    sput-object v1, Lcom/amazon/android/webkit/android/AndroidPluginManager;->PLUGIN_MANAGER:Ljava/lang/Class;

    .line 18
    sget-object v1, Lcom/amazon/android/webkit/android/AndroidPluginManager;->PLUGIN_MANAGER:Ljava/lang/Class;

    const-string/jumbo v2, "getInstance"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Landroid/content/Context;

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Lcom/amazon/android/webkit/android/AndroidPluginManager;->GET_INSTANCE:Ljava/lang/reflect/Method;

    .line 19
    sget-object v1, Lcom/amazon/android/webkit/android/AndroidPluginManager;->PLUGIN_MANAGER:Ljava/lang/Class;

    const-string/jumbo v2, "refreshPlugins"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    sget-object v5, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Lcom/amazon/android/webkit/android/AndroidPluginManager;->REFRESH_PLUGINS:Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 23
    return-void

    .line 20
    :catch_0
    move-exception v0

    .line 21
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v1
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    sget-object v0, Lcom/amazon/android/webkit/android/AndroidPluginManager;->GET_INSTANCE:Ljava/lang/reflect/Method;

    const/4 v1, 0x0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidPluginManager;->receiver:Ljava/lang/Object;

    .line 29
    return-void
.end method
