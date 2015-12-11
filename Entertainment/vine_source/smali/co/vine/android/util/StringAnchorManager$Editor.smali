.class public Lco/vine/android/util/StringAnchorManager$Editor;
.super Ljava/lang/Object;
.source "StringAnchorManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/StringAnchorManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Editor"
.end annotation


# instance fields
.field private final mEditor:Landroid/content/SharedPreferences$Editor;

.field private final mType:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput-object p1, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mEditor:Landroid/content/SharedPreferences$Editor;

    .line 51
    iput-object p2, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mType:Ljava/lang/String;

    .line 52
    return-void
.end method


# virtual methods
.method public commit()V
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mEditor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 72
    return-void
.end method

.method public setAnchor(Ljava/lang/String;)V
    .locals 3
    .param p1, "anchor"    # Ljava/lang/String;

    .prologue
    .line 59
    iget-object v0, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mEditor:Landroid/content/SharedPreferences$Editor;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "anchor_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 60
    return-void
.end method

.method public setIndex(J)V
    .locals 3
    .param p1, "index"    # J

    .prologue
    .line 63
    iget-object v0, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mEditor:Landroid/content/SharedPreferences$Editor;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "index_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 64
    return-void
.end method

.method public setLastId(J)V
    .locals 3
    .param p1, "lastId"    # J

    .prologue
    .line 67
    iget-object v0, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mEditor:Landroid/content/SharedPreferences$Editor;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "lastId_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 68
    return-void
.end method

.method public setRefreshTime(J)V
    .locals 3
    .param p1, "refreshTime"    # J

    .prologue
    .line 55
    iget-object v0, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mEditor:Landroid/content/SharedPreferences$Editor;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "refresh_time_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/util/StringAnchorManager$Editor;->mType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1, p2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 56
    return-void
.end method
