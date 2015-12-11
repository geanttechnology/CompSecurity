.class Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;
.super Ljava/lang/Thread;
.source "VirtuosoService.java"


# static fields
.field private static LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1155
    const-class v0, Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;->LOG_TAG:Ljava/lang/String;

    .line 1152
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1179
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;->LOG_TAG:Ljava/lang/String;

    const-string v1, "VirtuosoServiceThread(): run: begin"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1181
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;->LOG_TAG:Ljava/lang/String;

    const-string v1, "VirtuosoServiceThread(): run: end"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1182
    return-void
.end method

.method public start()V
    .locals 0

    .prologue
    .line 1172
    invoke-super {p0}, Ljava/lang/Thread;->start()V

    .line 1173
    return-void
.end method
