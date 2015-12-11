.class public final Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;
.super Ljava/lang/Object;
.source "FileFragment.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/database/impl/provider/FileFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "FragmentColumns"
.end annotation


# direct methods
.method public static final CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p0, "Authority"    # Ljava/lang/String;

    .prologue
    .line 24
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "content://"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/fragment"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method
