.class public Lcom/poshmark/data_model/models/UserStateSummary$Brands;
.super Ljava/lang/Object;
.source "UserStateSummary.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/UserStateSummary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Brands"
.end annotation


# instance fields
.field public all:Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;

.field public following:Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;

.field final synthetic this$0:Lcom/poshmark/data_model/models/UserStateSummary;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/UserStateSummary;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/poshmark/data_model/models/UserStateSummary$Brands;->this$0:Lcom/poshmark/data_model/models/UserStateSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
