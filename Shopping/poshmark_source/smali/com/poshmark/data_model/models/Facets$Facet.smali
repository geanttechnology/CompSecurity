.class public Lcom/poshmark/data_model/models/Facets$Facet;
.super Ljava/lang/Object;
.source "Facets.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/Facets;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Facet"
.end annotation


# instance fields
.field public _type:Ljava/lang/String;

.field public missing:I

.field public other:I

.field public terms:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Facets$FacetItem;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/data_model/models/Facets;

.field public total:I


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/Facets;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/poshmark/data_model/models/Facets$Facet;->this$0:Lcom/poshmark/data_model/models/Facets;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
