.class Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;
.super Ljava/lang/Object;
.source "ExperimentRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/feature/ExperimentRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "TreatmentEvent"
.end annotation


# instance fields
.field private final cacheStamp:Ljava/lang/Integer;

.field private final featureName:Ljava/lang/String;

.field private final session:Ljava/lang/String;

.field private final time:J

.field private final treatment:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 0
    .param p1, "session"    # Ljava/lang/String;
    .param p2, "time"    # J
    .param p4, "featureName"    # Ljava/lang/String;
    .param p5, "treatment"    # Ljava/lang/String;
    .param p6, "cacheStamp"    # Ljava/lang/Integer;

    .prologue
    .line 268
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 269
    iput-object p1, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->session:Ljava/lang/String;

    .line 270
    iput-wide p2, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->time:J

    .line 271
    iput-object p4, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->featureName:Ljava/lang/String;

    .line 272
    iput-object p5, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->treatment:Ljava/lang/String;

    .line 273
    iput-object p6, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->cacheStamp:Ljava/lang/Integer;

    .line 274
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/feature/ExperimentRecorder$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # J
    .param p4, "x2"    # Ljava/lang/String;
    .param p5, "x3"    # Ljava/lang/String;
    .param p6, "x4"    # Ljava/lang/Integer;
    .param p7, "x5"    # Lcom/amazon/mShop/feature/ExperimentRecorder$1;

    .prologue
    .line 258
    invoke-direct/range {p0 .. p6}, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;-><init>(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->session:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)J
    .locals 2
    .param p0, "x0"    # Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    .prologue
    .line 258
    iget-wide v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->time:J

    return-wide v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->treatment:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->featureName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;)Ljava/lang/Integer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->cacheStamp:Ljava/lang/Integer;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 278
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 280
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string/jumbo v1, "session: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->session:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", time: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->time:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", featureName: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->featureName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", treatment: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->treatment:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", cacheStamp: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$TreatmentEvent;->cacheStamp:Ljava/lang/Integer;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 286
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
