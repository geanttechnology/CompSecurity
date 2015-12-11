.class public Lcom/poshmark/data_model/models/Catalog$Catalogue;
.super Ljava/lang/Object;
.source "Catalog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/Catalog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Catalogue"
.end annotation


# instance fields
.field departments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Entry;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/data_model/models/Catalog;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/Catalog;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/poshmark/data_model/models/Catalog$Catalogue;->this$0:Lcom/poshmark/data_model/models/Catalog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
