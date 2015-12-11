.class public Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnPauseBuilder;
.super Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;
.source "SessionEventTypeBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OnPauseBuilder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder;-><init>(Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$1;)V

    return-void
.end method


# virtual methods
.method getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    const-string/jumbo v0, "onPause"

    return-object v0
.end method
