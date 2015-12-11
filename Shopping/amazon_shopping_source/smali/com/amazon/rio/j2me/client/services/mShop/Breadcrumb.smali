.class public Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;
.super Ljava/lang/Object;
.source "Breadcrumb.java"


# instance fields
.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;->name:Ljava/lang/String;

    .line 23
    return-void
.end method
