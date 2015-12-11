.class public Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;
.super Ljava/lang/Object;
.source "AllBrandsModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/db/AllBrandsModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "LastUpdateDTM"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/db/AllBrandsModel;

.field public updated_at:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/db/AllBrandsModel;)V
    .locals 0

    .prologue
    .line 17
    iput-object p1, p0, Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;->this$0:Lcom/poshmark/db/AllBrandsModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
