.class public final Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;
.super Ljava/lang/Object;


# instance fields
.field private data:Ljava/lang/Object;

.field private final duration:J

.field private final id:Ljava/lang/String;

.field private final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->id:Ljava/lang/String;

    iput-object p2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->url:Ljava/lang/String;

    iput-wide p3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->duration:J

    iput-object p5, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->data:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final getData()Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->data:Ljava/lang/Object;

    return-object v0
.end method

.method public final getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->duration:J

    return-wide v0
.end method

.method public final getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->id:Ljava/lang/String;

    return-object v0
.end method

.method public final getUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AdInfo;->url:Ljava/lang/String;

    return-object v0
.end method
