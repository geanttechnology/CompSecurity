.class Lco/vine/android/util/Util$AddressBookContact;
.super Ljava/lang/Object;
.source "Util.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/Util;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AddressBookContact"
.end annotation


# instance fields
.field public emails:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/util/HashSet",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;>;"
        }
    .end annotation
.end field

.field public name:Ljava/lang/String;

.field public phones:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/util/HashSet",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;>;"
        }
    .end annotation
.end field

.field public starred:Z

.field public timesContacted:I


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 865
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 866
    iput-object p1, p0, Lco/vine/android/util/Util$AddressBookContact;->name:Ljava/lang/String;

    .line 867
    iput-boolean v0, p0, Lco/vine/android/util/Util$AddressBookContact;->starred:Z

    .line 868
    iput v0, p0, Lco/vine/android/util/Util$AddressBookContact;->timesContacted:I

    .line 869
    return-void
.end method


# virtual methods
.method public addEmail(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "label"    # Ljava/lang/String;
    .param p2, "email"    # Ljava/lang/String;

    .prologue
    .line 872
    iget-object v1, p0, Lco/vine/android/util/Util$AddressBookContact;->emails:Ljava/util/HashSet;

    if-nez v1, :cond_0

    .line 873
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    iput-object v1, p0, Lco/vine/android/util/Util$AddressBookContact;->emails:Ljava/util/HashSet;

    .line 875
    :cond_0
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 876
    .local v0, "fields":Ljava/util/HashSet;, "Ljava/util/HashSet<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "emailAddress"

    invoke-direct {v1, v2, p2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 877
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 878
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "label"

    invoke-direct {v1, v2, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 880
    :cond_1
    iget-object v1, p0, Lco/vine/android/util/Util$AddressBookContact;->emails:Ljava/util/HashSet;

    invoke-virtual {v1, v0}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 881
    return-void
.end method

.method public addPhone(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "label"    # Ljava/lang/String;
    .param p2, "phone"    # Ljava/lang/String;

    .prologue
    .line 884
    iget-object v1, p0, Lco/vine/android/util/Util$AddressBookContact;->phones:Ljava/util/HashSet;

    if-nez v1, :cond_0

    .line 885
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    iput-object v1, p0, Lco/vine/android/util/Util$AddressBookContact;->phones:Ljava/util/HashSet;

    .line 887
    :cond_0
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 888
    .local v0, "fields":Ljava/util/HashSet;, "Ljava/util/HashSet<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "phoneNumber"

    invoke-direct {v1, v2, p2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 889
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 890
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "label"

    invoke-direct {v1, v2, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 892
    :cond_1
    iget-object v1, p0, Lco/vine/android/util/Util$AddressBookContact;->phones:Ljava/util/HashSet;

    invoke-virtual {v1, v0}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 893
    return-void
.end method

.method public setStarred()V
    .locals 1

    .prologue
    .line 896
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/util/Util$AddressBookContact;->starred:Z

    .line 897
    return-void
.end method

.method public setTimesContacted(I)V
    .locals 0
    .param p1, "timesContacted"    # I

    .prologue
    .line 900
    iput p1, p0, Lco/vine/android/util/Util$AddressBookContact;->timesContacted:I

    .line 901
    return-void
.end method
