.class Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;
.super Ljava/lang/Object;
.source "VirtuosoService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/service/VirtuosoService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "QuotaResetter"
.end annotation


# instance fields
.field client:Ljava/lang/String;

.field final synthetic this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;


# direct methods
.method public constructor <init>(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;)V
    .locals 0
    .param p2, "aclient"    # Ljava/lang/String;

    .prologue
    .line 563
    iput-object p1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 564
    iput-object p2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;->client:Ljava/lang/String;

    .line 565
    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 568
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;->client:Ljava/lang/String;

    const/4 v2, 0x1

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performQuotaReset(Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V
    invoke-static {v0, p0, v1, v2}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$4(Lcom/penthera/virtuososdk/service/VirtuosoService;Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V

    .line 569
    return-void
.end method
