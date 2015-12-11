.class public Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;
.super Ljava/lang/Object;
.source "UserStateSummary.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/UserStateSummary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "EventInvites"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/models/UserStateSummary;

.field public updated_at:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/UserStateSummary;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;->this$0:Lcom/poshmark/data_model/models/UserStateSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
