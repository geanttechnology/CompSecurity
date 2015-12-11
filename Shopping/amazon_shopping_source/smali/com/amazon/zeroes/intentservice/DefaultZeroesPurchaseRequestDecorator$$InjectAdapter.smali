.class public final Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator$$InjectAdapter;
.super Ldagger/internal/Binding;
.source "DefaultZeroesPurchaseRequestDecorator$$InjectAdapter.java"

# interfaces
.implements Ljavax/inject/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ldagger/internal/Binding",
        "<",
        "Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;",
        ">;",
        "Ljavax/inject/Provider",
        "<",
        "Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 18
    const-string/jumbo v0, "com.amazon.zeroes.intentservice.DefaultZeroesPurchaseRequestDecorator"

    const-string/jumbo v1, "members/com.amazon.zeroes.intentservice.DefaultZeroesPurchaseRequestDecorator"

    const/4 v2, 0x0

    const-class v3, Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;

    invoke-direct {p0, v0, v1, v2, v3}, Ldagger/internal/Binding;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;)V

    .line 19
    return-void
.end method


# virtual methods
.method public get()Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;

    invoke-direct {v0}, Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;-><init>()V

    .line 28
    .local v0, "result":Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;
    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 14
    invoke-virtual {p0}, Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator$$InjectAdapter;->get()Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;

    move-result-object v0

    return-object v0
.end method
