.class public final Lcom/adobe/mediacore/timeline/advertising/AdClick;
.super Ljava/lang/Object;


# instance fields
.field private final _id:Ljava/lang/String;

.field private final _title:Ljava/lang/String;

.field private final _url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_id:Ljava/lang/String;

    iput-object p2, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_title:Ljava/lang/String;

    iput-object p3, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_url:Ljava/lang/String;

    return-void
.end method

.method public static newInstance(Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .locals 4

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdClick;

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_id:Ljava/lang/String;

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_title:Ljava/lang/String;

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_url:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/timeline/advertising/AdClick;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_id:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_title:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_url:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Object {"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " url="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_url:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " ,title="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_title:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " ,id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdClick;->_id:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
