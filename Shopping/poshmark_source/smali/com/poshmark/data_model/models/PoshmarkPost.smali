.class public Lcom/poshmark/data_model/models/PoshmarkPost;
.super Ljava/lang/Object;
.source "PoshmarkPost.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/PoshmarkPost$PostImage;,
        Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;,
        Lcom/poshmark/data_model/models/PoshmarkPost$PostTitle;
    }
.end annotation


# instance fields
.field public image:Lcom/poshmark/data_model/models/PoshmarkPost$PostImage;

.field public target:Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;

.field public text:Lcom/poshmark/data_model/models/PoshmarkPost$PostTitle;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method
