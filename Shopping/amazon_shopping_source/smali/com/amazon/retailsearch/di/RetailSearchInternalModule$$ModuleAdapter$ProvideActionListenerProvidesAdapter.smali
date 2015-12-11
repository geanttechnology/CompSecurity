.class public final Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;
.super Ldagger/internal/ProvidesBinding;
.source "RetailSearchInternalModule$$ModuleAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ProvideActionListenerProvidesAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/ProvidesBinding",
        "<",
        "Lcom/amazon/retailsearch/interaction/UserInteractionListener;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/retailsearch/interaction/UserInteractionListener;",
        ">;"
    }
.end annotation


# instance fields
.field private final module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/di/RetailSearchInternalModule;)V
    .locals 4
    .param p1, "module"    # Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    .prologue
    .line 168
    const-string/jumbo v0, "com.amazon.retailsearch.interaction.UserInteractionListener"

    const/4 v1, 0x1

    const-string/jumbo v2, "com.amazon.retailsearch.di.RetailSearchInternalModule"

    const-string/jumbo v3, "provideActionListener"

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/ProvidesBinding;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 169
    iput-object p1, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;->module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    .line 170
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;->setLibrary(Z)V

    .line 171
    return-void
.end method


# virtual methods
.method public get()Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;->module:Lcom/amazon/retailsearch/di/RetailSearchInternalModule;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule;->provideActionListener()Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 163
    invoke-virtual {p0}, Lcom/amazon/retailsearch/di/RetailSearchInternalModule$$ModuleAdapter$ProvideActionListenerProvidesAdapter;->get()Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    move-result-object v0

    return-object v0
.end method
