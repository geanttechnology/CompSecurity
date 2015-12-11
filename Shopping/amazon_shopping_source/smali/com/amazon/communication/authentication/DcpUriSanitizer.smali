.class Lcom/amazon/communication/authentication/DcpUriSanitizer;
.super Ljava/lang/Object;


# static fields
.field private static final FAKE_URI:Landroid/net/Uri;

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.DcpUriUtil"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/authentication/DcpUriSanitizer;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v0, "http://www.amazon.com/workAroundDcpBlackList"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/communication/authentication/DcpUriSanitizer;->FAKE_URI:Landroid/net/Uri;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static sanitizeUriForDcp(Landroid/net/Uri;)Landroid/net/Uri;
    .locals 5

    const/4 v0, 0x0

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "DeviceEventProxy"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/amazon/communication/authentication/DcpUriSanitizer;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "sanitizeUriForDcp"

    const-string/jumbo v3, "Using fake URI to work-around DCP blacklist."

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    sget-object v0, Lcom/amazon/communication/authentication/DcpUriSanitizer;->FAKE_URI:Landroid/net/Uri;

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_3

    :cond_2
    sget-object v1, Lcom/amazon/communication/authentication/DcpUriSanitizer;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "signRequest"

    const-string/jumbo v3, "No path or null path in URI, appending / as a workaround"

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    const/4 v0, 0x1

    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "ws://"

    const-string/jumbo v4, "http://"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "wss://"

    const-string/jumbo v4, "https://"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    if-eqz v0, :cond_4

    const-string/jumbo v0, "/"

    :goto_1
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    :cond_4
    const-string/jumbo v0, ""

    goto :goto_1
.end method
