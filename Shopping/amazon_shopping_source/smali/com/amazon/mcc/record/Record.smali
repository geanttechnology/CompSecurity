.class public Lcom/amazon/mcc/record/Record;
.super Ljava/lang/Object;
.source "Record.java"

# interfaces
.implements Lcom/amazon/mcc/record/Recordable;


# instance fields
.field private final properties:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    .line 54
    return-void
.end method

.method protected constructor <init>(Lcom/amazon/mcc/record/Recordable;)V
    .locals 2
    .param p1, "record"    # Lcom/amazon/mcc/record/Recordable;

    .prologue
    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 145
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    .line 146
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    invoke-interface {p1}, Lcom/amazon/mcc/record/Recordable;->getProperties()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 147
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/amazon/mcc/record/Record;-><init>()V

    .line 76
    invoke-virtual {p0, p1}, Lcom/amazon/mcc/record/Record;->setName(Ljava/lang/String;)V

    .line 77
    const-string/jumbo v0, "Simple"

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/Record;->setType(Ljava/lang/String;)V

    .line 78
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "duration"    # J
    .param p4, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 117
    invoke-direct {p0}, Lcom/amazon/mcc/record/Record;-><init>()V

    .line 118
    invoke-virtual {p0, p1}, Lcom/amazon/mcc/record/Record;->setName(Ljava/lang/String;)V

    .line 119
    const-string/jumbo v0, "Duration"

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/Record;->setType(Ljava/lang/String;)V

    .line 120
    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mcc/record/Record;->setValue(Ljava/lang/Number;)V

    .line 121
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    const-string/jumbo v1, "TimeUnit"

    invoke-interface {v0, v1, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 122
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 133
    invoke-direct {p0}, Lcom/amazon/mcc/record/Record;-><init>()V

    .line 134
    invoke-virtual {p0, p1}, Lcom/amazon/mcc/record/Record;->setName(Ljava/lang/String;)V

    .line 135
    const-string/jumbo v0, "Message"

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/Record;->setType(Ljava/lang/String;)V

    .line 136
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    const-string/jumbo v1, "MessageContents"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    return-void
.end method

.method public static build(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mcc/record/RecordBuilder;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 65
    new-instance v0, Lcom/amazon/mcc/record/RecordBuilder;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mcc/record/RecordBuilder;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private setValue(Ljava/lang/Number;)V
    .locals 2
    .param p1, "duration"    # Ljava/lang/Number;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    const-string/jumbo v1, "Value"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    return-void
.end method


# virtual methods
.method public getProperties()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method setName(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    const-string/jumbo v1, "Name"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    return-void
.end method

.method protected setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    return-void
.end method

.method protected setType(Ljava/lang/String;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mcc/record/Record;->properties:Ljava/util/Map;

    const-string/jumbo v1, "RecordType"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    return-void
.end method
