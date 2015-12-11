.class public Lcom/poshmark/data_model/models/UserStateSummary$Collections;
.super Ljava/lang/Object;
.source "UserStateSummary.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/UserStateSummary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Collections"
.end annotation


# instance fields
.field public posts:Lcom/poshmark/data_model/models/UserStateSummary$Posts;

.field final synthetic this$0:Lcom/poshmark/data_model/models/UserStateSummary;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/UserStateSummary;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/poshmark/data_model/models/UserStateSummary$Collections;->this$0:Lcom/poshmark/data_model/models/UserStateSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
