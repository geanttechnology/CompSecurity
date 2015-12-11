.class public final Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "ActivityContext$$InjectAdapter.java"

# interfaces
.implements Ldagger/MembersInjector;
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/mcc/record/android/activity/ActivityContext;",
        ">;",
        "Ldagger/MembersInjector",
        "<",
        "Lcom/amazon/mcc/record/android/activity/ActivityContext;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/mcc/record/android/activity/ActivityContext;",
        ">;"
    }
.end annotation


# instance fields
.field private activity:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private supertype:Ldagger/internal/Binding;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/internal/Binding",
            "<",
            "Lcom/amazon/mcc/record/android/DeviceContext;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 29
    const-string/jumbo v0, "com.amazon.mcc.record.android.activity.ActivityContext"

    const-string/jumbo v1, "members/com.amazon.mcc.record.android.activity.ActivityContext"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/mcc/record/android/activity/ActivityContext;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 30
    return-void
.end method


# virtual methods
.method public attach(Ldagger/internal/Linker;)V
    .locals 6
    .param p1, "linker"    # Ldagger/internal/Linker;

    .prologue
    .line 39
    const-string/jumbo v0, "android.app.Activity"

    const-class v1, Lcom/amazon/mcc/record/android/activity/ActivityContext;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p1, v0, v1, v2}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->activity:Ldagger/internal/Binding;

    .line 40
    const-string/jumbo v1, "members/com.amazon.mcc.record.android.DeviceContext"

    const-class v2, Lcom/amazon/mcc/record/android/activity/ActivityContext;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Ldagger/internal/Linker;->requestBinding(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ClassLoader;ZZ)Ldagger/internal/Binding;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->supertype:Ldagger/internal/Binding;

    .line 41
    return-void
.end method

.method public get()Lcom/amazon/mcc/record/android/activity/ActivityContext;
    .locals 2

    .prologue
    .line 59
    new-instance v0, Lcom/amazon/mcc/record/android/activity/ActivityContext;

    iget-object v1, p0, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->activity:Ldagger/internal/Binding;

    invoke-virtual {v1}, Ldagger/internal/Binding;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    invoke-direct {v0, v1}, Lcom/amazon/mcc/record/android/activity/ActivityContext;-><init>(Landroid/app/Activity;)V

    .line 60
    .local v0, "result":Lcom/amazon/mcc/record/android/activity/ActivityContext;
    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->injectMembers(Lcom/amazon/mcc/record/android/activity/ActivityContext;)V

    .line 61
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->get()Lcom/amazon/mcc/record/android/activity/ActivityContext;

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
    .line 49
    .local p1, "getBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    .local p2, "injectMembersBindings":Ljava/util/Set;, "Ljava/util/Set<Ldagger/internal/Binding<*>;>;"
    iget-object v0, p0, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->activity:Ldagger/internal/Binding;

    invoke-interface {p1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 50
    iget-object v0, p0, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->supertype:Ldagger/internal/Binding;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 51
    return-void
.end method

.method public injectMembers(Lcom/amazon/mcc/record/android/activity/ActivityContext;)V
    .locals 1
    .param p1, "object"    # Lcom/amazon/mcc/record/android/activity/ActivityContext;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->supertype:Ldagger/internal/Binding;

    invoke-virtual {v0, p1}, Ldagger/internal/Binding;->injectMembers(Ljava/lang/Object;)V

    .line 71
    return-void
.end method

.method public bridge synthetic injectMembers(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/mcc/record/android/activity/ActivityContext;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mcc/record/android/activity/ActivityContext$$InjectAdapter;->injectMembers(Lcom/amazon/mcc/record/android/activity/ActivityContext;)V

    return-void
.end method
