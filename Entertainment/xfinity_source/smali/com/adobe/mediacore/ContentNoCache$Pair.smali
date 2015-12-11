.class Lcom/adobe/mediacore/ContentNoCache$Pair;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/ContentNoCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Pair"
.end annotation


# instance fields
.field private _adHandle:Lcom/adobe/mediacore/AdHandle;

.field private _url:Ljava/lang/String;

.field final synthetic this$0:Lcom/adobe/mediacore/ContentNoCache;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/ContentNoCache;Ljava/lang/String;Lcom/adobe/mediacore/AdHandle;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/ContentNoCache$Pair;->this$0:Lcom/adobe/mediacore/ContentNoCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lcom/adobe/mediacore/ContentNoCache$Pair;->_url:Ljava/lang/String;

    iput-object p3, p0, Lcom/adobe/mediacore/ContentNoCache$Pair;->_adHandle:Lcom/adobe/mediacore/AdHandle;

    return-void
.end method


# virtual methods
.method getAdHandle()Lcom/adobe/mediacore/AdHandle;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache$Pair;->_adHandle:Lcom/adobe/mediacore/AdHandle;

    return-object v0
.end method

.method getUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentNoCache$Pair;->_url:Ljava/lang/String;

    return-object v0
.end method
