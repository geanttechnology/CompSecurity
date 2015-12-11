.class public Lcom/poshmark/data_model/models/BrandShareMessageContainer;
.super Ljava/lang/Object;
.source "BrandShareMessageContainer.java"


# instance fields
.field public data:Lcom/poshmark/data_model/models/BrandShareMessages;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBrandShareMessages()Lcom/poshmark/data_model/models/BrandShareMessages;
    .locals 1

    .prologue
    .line 9
    iget-object v0, p0, Lcom/poshmark/data_model/models/BrandShareMessageContainer;->data:Lcom/poshmark/data_model/models/BrandShareMessages;

    return-object v0
.end method
