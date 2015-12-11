.class public Lcom/poshmark/data_model/models/Facets$FacetItem;
.super Ljava/lang/Object;
.source "Facets.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/Facets;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FacetItem"
.end annotation


# instance fields
.field public count:I

.field public term:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/Facets;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/Facets;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/poshmark/data_model/models/Facets$FacetItem;->this$0:Lcom/poshmark/data_model/models/Facets;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDisplay()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets$FacetItem;->term:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/poshmark/data_model/models/Facets$FacetItem;->term:Ljava/lang/String;

    return-object v0
.end method
