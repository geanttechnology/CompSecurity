.class public Lcom/poshmark/data_model/models/PoshmarkPost$PostImage;
.super Ljava/lang/Object;
.source "PoshmarkPost.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/PoshmarkPost;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PostImage"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/models/PoshmarkPost;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/PoshmarkPost;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/poshmark/data_model/models/PoshmarkPost$PostImage;->this$0:Lcom/poshmark/data_model/models/PoshmarkPost;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
