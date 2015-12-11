.class public Lcom/amazon/mcc/record/RecordBuilder;
.super Ljava/lang/Object;
.source "RecordBuilder.java"


# instance fields
.field private record:Lcom/amazon/mcc/record/Record;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Lcom/amazon/mcc/record/Record;

    invoke-direct {v0}, Lcom/amazon/mcc/record/Record;-><init>()V

    iput-object v0, p0, Lcom/amazon/mcc/record/RecordBuilder;->record:Lcom/amazon/mcc/record/Record;

    .line 18
    iget-object v0, p0, Lcom/amazon/mcc/record/RecordBuilder;->record:Lcom/amazon/mcc/record/Record;

    invoke-virtual {v0, p1}, Lcom/amazon/mcc/record/Record;->setName(Ljava/lang/String;)V

    .line 19
    iget-object v0, p0, Lcom/amazon/mcc/record/RecordBuilder;->record:Lcom/amazon/mcc/record/Record;

    invoke-virtual {v0, p2}, Lcom/amazon/mcc/record/Record;->setType(Ljava/lang/String;)V

    .line 20
    return-void
.end method


# virtual methods
.method public create()Lcom/amazon/mcc/record/Record;
    .locals 2

    .prologue
    .line 40
    new-instance v0, Lcom/amazon/mcc/record/Record;

    iget-object v1, p0, Lcom/amazon/mcc/record/RecordBuilder;->record:Lcom/amazon/mcc/record/Record;

    invoke-direct {v0, v1}, Lcom/amazon/mcc/record/Record;-><init>(Lcom/amazon/mcc/record/Recordable;)V

    return-object v0
.end method

.method public with(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/mcc/record/RecordBuilder;
    .locals 1
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/mcc/record/RecordBuilder;->record:Lcom/amazon/mcc/record/Record;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mcc/record/Record;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 32
    return-object p0
.end method
