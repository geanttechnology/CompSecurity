.class public Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;
.super Ljava/lang/Object;
.source "CustomerAttributeStoreFactory.java"


# instance fields
.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 13
    return-void
.end method


# virtual methods
.method public createCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;
    .locals 2

    .prologue
    .line 17
    new-instance v0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreFactory;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V

    return-object v0
.end method
