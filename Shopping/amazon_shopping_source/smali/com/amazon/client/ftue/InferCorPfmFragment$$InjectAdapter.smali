.class public final Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "InferCorPfmFragment$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/client/ftue/InferCorPfmFragment;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/client/ftue/InferCorPfmFragment;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/client/ftue/InferCorPfmFragment;",
        ">;"
    }
.end annotation


# instance fields
.field private accountManager:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/identity/auth/device/api/MAPAccountManager;",
            ">;"
        }
    .end annotation
.end field

.field private authCookieHelper:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/venezia/web/AuthCookieHelper;",
            ">;>;"
        }
    .end annotation
.end field

.field private deviceInspector:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/mas/client/device/DeviceInspector;",
            ">;"
        }
    .end annotation
.end field

.field private hardware:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/mas/client/device/hardware/HardwareEvaluator;",
            ">;"
        }
    .end annotation
.end field

.field private inferredCorPfm:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/mas/client/authentication/InferredCorPfm;",
            ">;"
        }
    .end annotation
.end field

.field private openglInterrogator:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;",
            ">;"
        }
    .end annotation
.end field

.field private pageUrlFactory:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/venezia/web/PageUrlFactory;",
            ">;"
        }
    .end annotation
.end field

.field private resourceCache:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/mcc/resources/ResourceCache;",
            ">;"
        }
    .end annotation
.end field

.field private webViewFactory:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/venezia/web/WebViewBuilder;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 36
    const-string/jumbo v0, "com.amazon.client.ftue.InferCorPfmFragment"

    const-string/jumbo v1, "members/com.amazon.client.ftue.InferCorPfmFragment"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 37
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 3
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 46
    const-string/jumbo v0, "com.amazon.mas.client.device.software.opengl.OpenGlActivityInterrogator"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->openglInterrogator:Ldagger/internal/Binding;

    .line 47
    const-string/jumbo v0, "com.amazon.identity.auth.device.api.MAPAccountManager"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->accountManager:Ldagger/internal/Binding;

    .line 48
    const-string/jumbo v0, "com.amazon.mcc.resources.ResourceCache"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->resourceCache:Ldagger/internal/Binding;

    .line 49
    const-string/jumbo v0, "dagger.Lazy<com.amazon.venezia.web.AuthCookieHelper>"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->authCookieHelper:Ldagger/internal/Binding;

    .line 50
    const-string/jumbo v0, "com.amazon.mas.client.authentication.InferredCorPfm"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->inferredCorPfm:Ldagger/internal/Binding;

    .line 51
    const-string/jumbo v0, "com.amazon.venezia.web.WebViewBuilder"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->webViewFactory:Ldagger/internal/Binding;

    .line 52
    const-string/jumbo v0, "com.amazon.venezia.web.PageUrlFactory"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->pageUrlFactory:Ldagger/internal/Binding;

    .line 53
    const-string/jumbo v0, "com.amazon.mas.client.device.hardware.HardwareEvaluator"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->hardware:Ldagger/internal/Binding;

    .line 54
    const-string/jumbo v0, "com.amazon.mas.client.device.DeviceInspector"

    const-class v1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->deviceInspector:Ldagger/internal/Binding;

    .line 55
    return-void
.end method

.method public get()Lcom/amazon/client/ftue/InferCorPfmFragment;
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-direct {v0}, Lcom/amazon/client/ftue/InferCorPfmFragment;-><init>()V

    .line 81
    .local v0, "result":Lcom/amazon/client/ftue/InferCorPfmFragment;
    invoke-virtual {p0, v0}, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->injectMembers(Lcom/amazon/client/ftue/InferCorPfmFragment;)V

    .line 82
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->get()Lcom/amazon/client/ftue/InferCorPfmFragment;

    move-result-object v0

    return-object v0
.end method

.method public getDependencies(Ljava/util/Set;Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;",
            "Ljava/util/Set",
            "<",
            "Ldagger/internal/Binding",
            "<*>;>;)V"
        }
    .end annotation

    .prologue
    .line 63
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->openglInterrogator:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 64
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->accountManager:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 65
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->resourceCache:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 66
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->authCookieHelper:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 67
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->inferredCorPfm:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 68
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->webViewFactory:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 69
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->pageUrlFactory:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 70
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->hardware:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 71
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->deviceInspector:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 72
    return-void
.end method

.method public injectMembers(Lcom/amazon/client/ftue/InferCorPfmFragment;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/client/ftue/InferCorPfmFragment;

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->openglInterrogator:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->openglInterrogator:Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;

    .line 92
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->accountManager:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 93
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->resourceCache:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mcc/resources/ResourceCache;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->resourceCache:Lcom/amazon/mcc/resources/ResourceCache;

    .line 94
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->authCookieHelper:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ldagger/Lazy;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->authCookieHelper:Ldagger/Lazy;

    .line 95
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->inferredCorPfm:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mas/client/authentication/InferredCorPfm;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->inferredCorPfm:Lcom/amazon/mas/client/authentication/InferredCorPfm;

    .line 96
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->webViewFactory:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/venezia/web/WebViewBuilder;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->webViewFactory:Lcom/amazon/venezia/web/WebViewBuilder;

    .line 97
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->pageUrlFactory:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/venezia/web/PageUrlFactory;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->pageUrlFactory:Lcom/amazon/venezia/web/PageUrlFactory;

    .line 98
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->hardware:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mas/client/device/hardware/HardwareEvaluator;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->hardware:Lcom/amazon/mas/client/device/hardware/HardwareEvaluator;

    .line 99
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->deviceInspector:Ldagger/internal/Binding;

    invoke-virtual {v0}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mas/client/device/DeviceInspector;

    iput-object v0, p1, Lcom/amazon/client/ftue/InferCorPfmFragment;->deviceInspector:Lcom/amazon/mas/client/device/DeviceInspector;

    .line 100
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/client/ftue/InferCorPfmFragment;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/client/ftue/InferCorPfmFragment$$InjectAdapter;->injectMembers(Lcom/amazon/client/ftue/InferCorPfmFragment;)V

    return-void
.end method
