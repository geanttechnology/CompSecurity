.class public Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private date:Ljava/lang/String;

.field private emailAddress:Ljava/lang/String;

.field private firstName:Ljava/lang/String;

.field private lastName:Ljava/lang/String;

.field private phoneNumber:Ljava/lang/String;

.field private sendEmail:Z

.field private time:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->date:Ljava/lang/String;

    return-object v0
.end method

.method public getEmailAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->emailAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->phoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->time:Ljava/lang/String;

    return-object v0
.end method

.method public isSendEmail()Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->sendEmail:Z

    return v0
.end method

.method public setDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->date:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setEmailAddress(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->emailAddress:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setFirstName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->firstName:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setLastName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->lastName:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setPhoneNumber(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->phoneNumber:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setSendEmail(Z)V
    .locals 0

    .prologue
    .line 66
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->sendEmail:Z

    .line 67
    return-void
.end method

.method public setTime(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->time:Ljava/lang/String;

    .line 51
    return-void
.end method
