.class public Lcom/poshmark/data_model/models/Catalog$Entry;
.super Ljava/lang/Object;
.source "Catalog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/Catalog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Entry"
.end annotation


# instance fields
.field public categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Entry;",
            ">;"
        }
    .end annotation
.end field

.field public category_features:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Entry;",
            ">;"
        }
    .end annotation
.end field

.field public child_entries:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Entry;",
            ">;"
        }
    .end annotation
.end field

.field public display:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public listing_flow_enabled:Z

.field public sizes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Catalog$Size;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/data_model/models/Catalog;

.field public use_sizes_for_my_size:Z


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/Catalog;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/poshmark/data_model/models/Catalog$Entry;->this$0:Lcom/poshmark/data_model/models/Catalog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
