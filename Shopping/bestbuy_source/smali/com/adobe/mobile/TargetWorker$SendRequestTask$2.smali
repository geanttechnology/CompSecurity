.class Lcom/adobe/mobile/TargetWorker$SendRequestTask$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/adobe/mobile/RequestHandler$HeaderCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/TargetWorker$SendRequestTask;->run()V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mobile/TargetWorker$SendRequestTask;


# direct methods
.method constructor <init>(Lcom/adobe/mobile/TargetWorker$SendRequestTask;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/adobe/mobile/TargetWorker$SendRequestTask$2;->this$0:Lcom/adobe/mobile/TargetWorker$SendRequestTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 125
    # invokes: Lcom/adobe/mobile/TargetWorker;->readAndStoreCookiesFromHeaders(Ljava/util/Map;)V
    invoke-static {p1}, Lcom/adobe/mobile/TargetWorker;->access$300(Ljava/util/Map;)V

    .line 126
    return-void
.end method
