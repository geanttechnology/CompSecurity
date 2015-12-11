.class public Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;
.super Ljava/lang/Object;
.source "BrandShareMessages.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/BrandShareMessages;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ShareMessage"
.end annotation


# instance fields
.field public body:Ljava/lang/String;

.field public hint:Ljava/lang/String;

.field public message:Ljava/lang/String;

.field public subject:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/BrandShareMessages;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/BrandShareMessages;)V
    .locals 0

    .prologue
    .line 15
    iput-object p1, p0, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->this$0:Lcom/poshmark/data_model/models/BrandShareMessages;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
