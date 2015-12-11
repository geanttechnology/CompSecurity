.class Lcom/adobe/mobile/VisitorIDService$6;
.super Ljava/lang/Object;
.source "VisitorIDService.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/VisitorIDService;->getAAMParameterString()Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mobile/VisitorIDService;

.field final synthetic val$returnValue:Ljava/lang/StringBuilder;


# direct methods
.method constructor <init>(Lcom/adobe/mobile/VisitorIDService;Ljava/lang/StringBuilder;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/mobile/VisitorIDService;

    .prologue
    .line 351
    iput-object p1, p0, Lcom/adobe/mobile/VisitorIDService$6;->this$0:Lcom/adobe/mobile/VisitorIDService;

    iput-object p2, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 351
    invoke-virtual {p0}, Lcom/adobe/mobile/VisitorIDService$6;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 354
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->this$0:Lcom/adobe/mobile/VisitorIDService;

    # getter for: Lcom/adobe/mobile/VisitorIDService;->_marketingCloudID:Ljava/lang/String;
    invoke-static {v0}, Lcom/adobe/mobile/VisitorIDService;->access$000(Lcom/adobe/mobile/VisitorIDService;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 355
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 356
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "d_mid"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 357
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 358
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/adobe/mobile/VisitorIDService$6;->this$0:Lcom/adobe/mobile/VisitorIDService;

    # getter for: Lcom/adobe/mobile/VisitorIDService;->_marketingCloudID:Ljava/lang/String;
    invoke-static {v1}, Lcom/adobe/mobile/VisitorIDService;->access$000(Lcom/adobe/mobile/VisitorIDService;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 363
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->this$0:Lcom/adobe/mobile/VisitorIDService;

    # getter for: Lcom/adobe/mobile/VisitorIDService;->_blob:Ljava/lang/String;
    invoke-static {v0}, Lcom/adobe/mobile/VisitorIDService;->access$200(Lcom/adobe/mobile/VisitorIDService;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 365
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "d_blob"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 366
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 367
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/adobe/mobile/VisitorIDService$6;->this$0:Lcom/adobe/mobile/VisitorIDService;

    # getter for: Lcom/adobe/mobile/VisitorIDService;->_blob:Ljava/lang/String;
    invoke-static {v1}, Lcom/adobe/mobile/VisitorIDService;->access$200(Lcom/adobe/mobile/VisitorIDService;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 370
    :cond_0
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->this$0:Lcom/adobe/mobile/VisitorIDService;

    # getter for: Lcom/adobe/mobile/VisitorIDService;->_locationHint:Ljava/lang/String;
    invoke-static {v0}, Lcom/adobe/mobile/VisitorIDService;->access$100(Lcom/adobe/mobile/VisitorIDService;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 371
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 372
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "dcs_region"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 373
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 374
    iget-object v0, p0, Lcom/adobe/mobile/VisitorIDService$6;->val$returnValue:Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/adobe/mobile/VisitorIDService$6;->this$0:Lcom/adobe/mobile/VisitorIDService;

    # getter for: Lcom/adobe/mobile/VisitorIDService;->_locationHint:Ljava/lang/String;
    invoke-static {v1}, Lcom/adobe/mobile/VisitorIDService;->access$100(Lcom/adobe/mobile/VisitorIDService;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 377
    :cond_1
    return-object v2
.end method
